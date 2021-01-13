package com.nubari;

public class DateAndTime {
    private int hour;
    private int minute;
    private int second;
    int month;
    int day;
    int year;

    public DateAndTime(int day, int month, int year) {
        this(day, month, year, 0, 0, 0);
    }

    public DateAndTime(int day, int month, int year, int hour, int minute, int second) {
        boolean validMonthRange = month > 0 && month < 13;
        boolean validYearRange = year > 1899 && year < 2100;
        boolean monthIs30DayMonth = month == 4 || month == 6 || month == 9 || month == 11;
        boolean yearIsLeapYear = year % 4 == 0;
        boolean validDayRangeForLeapYearFebruary = day > 0 && day < 29;
        boolean validDayRangeForNonLeapYearFebruary = day > 0 && day < 28;
        boolean monthIsFebruary = month == 2;
        boolean validDayRangeFor30DayMonth = day > 0 && day < 31;
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

        if (validMonthRange) {
            this.month = month;
        }
        if (validYearRange) {
            this.year = year;
        }
        if (monthIs30DayMonth) {
            if (validDayRangeFor30DayMonth) {
                this.day = day;
            }
        }
        if (monthIsFebruary) {
            if (yearIsLeapYear) {
                if (validDayRangeForLeapYearFebruary) {
                    this.day = day;
                }
            }
            if (!yearIsLeapYear) {
                if (validDayRangeForNonLeapYearFebruary) {
                    this.day = day;
                }
            }
        }
        if (!monthIs30DayMonth && !monthIsFebruary) {
            boolean validDayRangeFor31DayMonth = day > 0 && day < 32;
            if (validDayRangeFor31DayMonth) {
                this.day = day;
            }
        }
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        boolean validMonthRange = month > 0 && month < 13;
        if (validMonthRange) {
            this.month = month;
        }
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        boolean monthIs30DayMonth = month == 4 || month == 6 || month == 9 || month == 11;
        boolean yearIsLeapYear = year % 4 == 0;
        boolean validDayRangeForLeapYearFebruary = day > 0 && day < 29;
        boolean validDayRangeForNonLeapYearFebruary = day > 0 && day < 28;
        boolean monthIsFebruary = month == 2;
        boolean validDayRangeFor30DayMonth = day > 0 && day < 31;
        if (monthIs30DayMonth) {
            if (validDayRangeFor30DayMonth) {
                this.day = day;
            }
        }
        if (monthIsFebruary) {
            if (yearIsLeapYear) {
                if (validDayRangeForLeapYearFebruary) {
                    this.day = day;
                }
            }
            if (!yearIsLeapYear) {
                if (validDayRangeForNonLeapYearFebruary) {
                    this.day = day;
                }
            }
        }
        if (!monthIs30DayMonth && !monthIsFebruary) {
            boolean validDayRangeFor31DayMonth = day > 0 && day < 32;
            if (validDayRangeFor31DayMonth) {
                this.day = day;
            }
        }

    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        boolean validYearRange = year > 1899 && year < 2100;
        if (validYearRange) {
            this.year = year;
        }
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

    public void displayDate() {
        System.out.println(getDay() + "/" + getMonth() + "/" + getYear());
    }

    public void nextDay() {
        boolean monthIs30DayMonth = month == 4 || month == 6 || month == 9 || month == 11;
        boolean yearIsLeapYear = year % 4 == 0;
        boolean monthIsFebruary = month == 2;
        if (monthIs30DayMonth) {
            if (day < 30) {
                day++;
            } else if (day == 30) {
                day = 1;
                if (month < 12) {
                    month++;
                } else if (month == 12) {
                    month = 1;
                    year++;
                }
            }
        } else if (monthIsFebruary) {
            if (!yearIsLeapYear) {
                if (day < 28) {
                    day++;
                } else if (day == 28) {
                    day = 1;
                    month++;
                }
            } else if (yearIsLeapYear) {
                if (day < 29) {
                    day++;
                } else if (day == 29) {
                    day = 1;
                    month++;
                }
            }
        } else {
            if (day < 31) {
                day++;
            } else if (day == 31) {
                day = 1;
                if (month < 12) {
                    month++;
                } else if (month == 12) {
                    month = 1;
                    year++;
                }
            }
        }
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
                    nextDay();
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
                    nextDay();
                }
            }
        }

    }

    public void incrementHour() {
        if (hour < 23) {
            hour++;
        } else if (hour == 23) {
            hour = 0;
            nextDay();
        }
    }


    public String toUniversalString() {
        return String.format(
                "%02d-%02d-%02d %02d:%02d:%02d", getDay(), getMonth(), getYear(), getHour(), getMinute(), getSecond()
        );
    }

    public String toString() {
        String dateString = String.format("%02d-%02d-%02d", getDay(), getMonth(), getYear());
        String timeString = String.format("%d:%02d:%02d %s",
                ((getHour() == 0 || getHour() == 12) ? 12 : getHour() % 12),
                getMinute(), getSecond(), (getHour() < 12 ? "AM" : "PM"));
        return dateString + timeString;
    }
}
