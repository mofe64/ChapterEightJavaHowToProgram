package com.nubari;

public class MultiFormatDate {
    int month;
    int day;
    int year;

    public MultiFormatDate(int month, int day, int year) {
        boolean validMonthRange = month > 0 && month < 13;
        boolean validYearRange = year > 1899 && year < 2100;
        boolean monthIs30DayMonth = month == 4 || month == 6 || month == 9 || month == 11;
        boolean yearIsLeapYear = year % 4 == 0;
        boolean validDayRangeForLeapYearFebruary = day > 0 && day < 29;
        boolean validDayRangeForNonLeapYearFebruary = day > 0 && day < 28;
        boolean monthIsFebruary = month == 2;
        boolean validDayRangeFor30DayMonth = day > 0 && day < 31;

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

    public void displayDate() {
        System.out.println(getDay() + "/" + getMonth() + "/" + getYear());
    }

    @Override
    public String toString() {
        return getDay() + "/" + getMonth() + "/" + getYear();
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

    void fastForwardByDay(int numberOfDays) {
        System.out.println("Today's date is " + this.toString());
        for (int i = 0; i < numberOfDays; i++) {
            nextDay();
            System.out.println(this.toString());

        }
    }

    public String printDateInMMDDYYYYFORMAT() {
        StringBuilder stringBuilder = new StringBuilder();
        if (getDay() < 9) {
            stringBuilder.append(0);
            stringBuilder.append(getDay());
            stringBuilder.append("/");
        }
        if (getDay() > 9) {
            stringBuilder.append(getDay());
            stringBuilder.append("/");
        }
        if (getMonth() < 9) {
            stringBuilder.append(0);
            stringBuilder.append(getMonth());
            stringBuilder.append("/");
        }
        if (getMonth() > 9) {
            stringBuilder.append(getMonth());
            stringBuilder.append("/");
        }
        stringBuilder.append(getYear());
        return stringBuilder.toString();
    }

    public String printDateInFullFormat() {
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        String month = months[getMonth()];
        return month + " " + getDay() + getYear();
    }

    public String printDateInDDDYYYYFormat() {
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        int[] daysOfEachMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int days = 0;
        for (int i = 0; i < getMonth(); i++) {
            //System.out.println(daysOfEachMonth[i]);
            days += daysOfEachMonth[i];
        }
        //System.out.println("Month :" + getMonth());
        //System.out.println("day : " + getDay());
        int diff = daysOfEachMonth[getMonth() - 1] - getDay();
        //System.out.println("diff : " + diff);
        days -= diff;
        if (getYear() % 4 == 0) {
            if (getMonth() > 2) {
                days += 1;
            } else if (getMonth() == 2 && (getDay() < 29)) {
                days += 1;
            }
        }
        return days + "/" + getYear();
    }
}
