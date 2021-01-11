package com.nubari;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {
    Rectangle rectangle;
    @BeforeEach
    void setUp() {
        rectangle = new Rectangle(5,5);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getLength() {
        assertEquals(5.0, rectangle.getLength());
    }

    @Test
    void setLength() {
        rectangle.setLength(10);
        assertEquals(10.0, rectangle.getLength());

    }
    @Test
    void testLengthCanOnlyBeSetWithinBounds(){
        rectangle.setLength(50);
        assertEquals(5.0, rectangle.getLength());
        rectangle.setLength(-7);
        assertEquals(5.0, rectangle.getLength());
    }
    @Test
    void getWidth() {
        assertEquals(5.0, rectangle.getWidth());
    }

    @Test
    void setWidth() {
        rectangle.setWidth(10);
        assertEquals(10.0, rectangle.getWidth());
    }
    @Test
    void testWidthCanOnlyBeSetWithinBounds(){
        rectangle.setWidth(50);
        assertEquals(5.0, rectangle.getLength());
        rectangle.setWidth(-7);
        assertEquals(5.0, rectangle.getLength());
    }

    @Test
    void calculatePerimeter() {
        double perimeterValue = (5.0 + 5.0) * 2;
        assertEquals(perimeterValue, rectangle.calculatePerimeter());
    }
}