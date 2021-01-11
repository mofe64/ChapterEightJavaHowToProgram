package com.nubari;

public class Time2Modified {
    private int hour;
    private int minute;
    private int second;

    public Time2Modified() {
        this(0, 0, 0);
    }

    public Time2Modified(int hour) {
        this(hour, 0, 0);
    }

    public Time2Modified(int hour, int minute) {
        this(hour, minute, 0);
    }

    public Time2Modified(int hour, int minute, int second) {
        if (hour < 0 || hour >= 24) {
            throw new IllegalArgumentException("Hour must be between 0-23");
        }
        if (minute < 0 || minute >= 60) {
            throw new IllegalArgumentException("Minute must be between 0-59");
        }
        if (second < 0 || second >= 60) {
            throw new IllegalArgumentException("Second must be between 0-59");
        }
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public Time2Modified(Time2 time) {
        this(time.getHour(), time.getMinute(), time.getSecond());
    }

    public void setTime(int hour, int minute, int second) {
        if (hour < 0 || hour >= 24) {
            throw new IllegalArgumentException("Hour must be between 0-23");
        }
        if (minute < 0 || minute >= 60) {
            throw new IllegalArgumentException("Minute must be between 0-59");
        }
        if (second < 0 || second >= 60) {
            throw new IllegalArgumentException("Second must be between 0-59");
        }
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public void setHour(int hour) {
        if (hour < 0 || hour >= 24) {
            throw new IllegalArgumentException("Hour must be between 0-23");
        }
        this.hour = hour;
    }

    public void setMinute(int minute) {
        if (minute < 0 || minute >= 60) {
            throw new IllegalArgumentException("Minute must be between 0-59");
        }
        this.minute = minute;
    }

    public void setSecond(int second) {
        if (second < 0 || second >= 60) {
            throw new IllegalArgumentException("Second must be between 0-59");
        }
        this.second = second;
    }

    public int getHour() {
        return this.hour;
    }

    public int getMinute() {
        return this.minute;
    }

    public int getSecond() {
        return this.second;
    }

    public String toUniversalString() {
        return String.format(
                "%02d:%02d:%02d", getHour(), getMinute(), getSecond()
        );
    }

    public String toString() {
        return String.format("%d:%02d:%02d %s",
                ((getHour() == 0 || getHour() == 12) ? 12 : getHour() % 12),
                getMinute(), getSecond(), (getHour() < 12 ? "AM" : "PM"));
    }

    public String secondsFromMidnight() {
        int hoursConvertedToSeconds = this.hour * 60 * 60;
        int minutesConvertedToSeconds = this.minute * 60;
        int seconds = this.second;
        int secondsFromMidnight = hoursConvertedToSeconds + minutesConvertedToSeconds + seconds;
        return "There have been " + secondsFromMidnight + " seconds from midnight";
    }

    public void tick() {
        if (second < 59) {
            second++;
        } else if (second == 59) {
            if (minute < 59) {
                minute++;
                second = 0;
            } else if (minute == 59) {
                if (hour < 23) {
                    this.hour += 1;
                    minute = 0;
                    second = 0;
                } else if (hour == 23) {
                    this.hour = 0;
                    this.minute = 0;
                    this.second = 0;
                }
            }
        }

    }

    public void incrementMinute() {
        if (minute < 59) {
            this.minute++;
        } else {
            if (minute == 59) {
                if (hour < 23) {
                    hour++;
                    minute = 0;
                } else if (hour == 23) {
                    hour = 0;
                    minute = 0;
                    second = 0;
                }
            }
        }

    }

    public void incrementHour() {
        if (hour < 23) {
            hour++;
        } else if (hour == 23) {
            hour = 0;
        }
    }
}
