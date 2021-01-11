package com.nubari;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Time2ModifiedTest {
    Time2Modified time;
    @BeforeEach
    void setUp(){
        time = new Time2Modified();
    }

    @Test
    void testTimeCanBeInitializedWithJustHourValue(){
        Time2 time = new Time2(10);
        assertEquals(10, time.getHour());
        assertEquals(0, time.getMinute());
        assertEquals(0, time.getSecond());
    }
    @Test
    void testTimeCanBeInitializedWithHourAndMinuteValues(){
        Time2 time = new Time2(10,30);
        assertEquals(10, time.getHour());
        assertEquals(30, time.getMinute());
        assertEquals(00, time.getSecond());
    }
    @Test
    void testTimeCanBeInitializedWithHourMinuteAndSecondValues(){
        Time2 time = new Time2(7,39, 10);
        assertEquals(7, time.getHour());
        assertEquals(39,time.getMinute());
        assertEquals(10, time.getSecond());
    }

    @Test
    void testTimeCanBeInitializedWithAnotherTimeObject(){
        Time2 time = new Time2(9,30,20);
        Time2 time2 = new Time2(time);
        assertEquals(9, time2.getHour());
        assertEquals(30, time2.getMinute());
        assertEquals(20, time2.getSecond());
    }
    @Test
    void setTime() {
        time.setTime(7, 30,00);
        assertEquals(7, time.getHour());
        assertEquals(30, time.getMinute());
        assertEquals(00, time.getSecond());
    }

    @Test
    void setHour() {
        time.setHour(6);
        assertEquals(6, time.getHour());
    }

    @Test
    void setMinute() {
        time.setMinute(40);
        assertEquals(40, time.getMinute());
    }

    @Test
    void setSecond() {
        time.setSecond(30);
        assertEquals(30, time.getSecond());
    }

    @Test
    void getHour() {
        assertEquals(0, time.getHour());
    }

    @Test
    void getMinute() {
        time.setMinute(40);
        assertEquals(40, time.getMinute());
    }

    @Test
    void getSecond() {
        time.setSecond(40);
        assertEquals(40, time.getSecond());
    }

    @Test
    void toUniversalString() {
        System.out.println(time.toUniversalString());
    }

    @Test
    void testToString() {
        System.out.println(time.toString());
    }

    @Test
    void secondsFromMidnight() {
        System.out.println(time.secondsFromMidnight());
    }

    @Test
    void testTick(){
        assertEquals(00,time.getSecond());
        time.tick();
        assertEquals(01, time.getSecond());
    }
    @Test
    void testIncrementMinute(){
        assertEquals(0, time.getMinute());
        time.incrementMinute();
        assertEquals(1, time.getMinute());
    }
    @Test
    void testIncrementHour(){
        assertEquals(0, time.getHour());
        time.incrementHour();
        assertEquals(1, time.getHour());
    }
    @Test
    void testTimeChange(){
        Time2Modified time = new Time2Modified(23,59, 59);
        System.out.println(time.toString());
        System.out.println(time.toUniversalString());
        time.tick();
        System.out.println(time.toString());
        System.out.println(time.toUniversalString());
        System.out.println();
        time = new Time2Modified(23,59,59);
        System.out.println(time.toString());
        System.out.println(time.toUniversalString());
        time.incrementMinute();
        System.out.println(time.toString());
        System.out.println(time.toUniversalString());
    }
}