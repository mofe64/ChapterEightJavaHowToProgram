package com.nubari;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DateTest {

    Date date;
    @BeforeEach
    void setUp() {
        date = new Date(1,27,1998);
    }

    @AfterEach
    void tearDown() {
        date = null;
    }

    @Test
    void getMonth() {
        assertEquals(1,date.getMonth());
    }

    @Test
    void setMonth() {
        date.setMonth(8);
        assertEquals(8,date.getMonth());
    }

    @Test
    void getDay() {
        assertEquals(27, date.getDay());
    }

    @Test
    void setDay() {
        date.setDay(20);
        assertEquals(20, date.getDay());
    }

    @Test
    void getYear() {
        assertEquals(1998,date.getYear());
    }

    @Test
    void setYear() {
        date.setYear(2003);
        assertEquals(2003,date.getYear());
    }

    @Test
    void displayDate() {
        date.displayDate();
    }
    @Test
    void test(){
        Date date = new Date(1, 1,2009);
        date.fastForwardByDay(365);

    }
}