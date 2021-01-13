package com.nubari;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntegerSetTest {
    IntegerSet integerSet;

    @BeforeEach
    void setUp() {
        integerSet = new IntegerSet();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testThatSetIsInitializedWhenIntegerSetIsInitialized() {
        IntegerSet integerSet = new IntegerSet();
        assertNotNull(integerSet.getSet());
    }

    @Test
    void insertElement() {
        integerSet.insertElement(8);
        assertTrue(integerSet.getSet()[8]);
        integerSet.insertElement(80);
        assertTrue(integerSet.getSet()[80]);
        integerSet.insertElement(100);
        assertTrue(integerSet.getSet()[100]);
    }

    @Test
    void deleteElement() {
        integerSet.insertElement(7);
        assertTrue(integerSet.getSet()[7]);
        integerSet.deleteElement(7);
        assertFalse(integerSet.getSet()[7]);
    }

    @Test
    void union() {
        IntegerSet integerSet1 = new IntegerSet();
        IntegerSet integerSet2 = new IntegerSet();
        IntegerSet unionIntegerSet = new IntegerSet();
        for (int i = 0; i < 10; i++) {
            integerSet1.insertElement(i);
        }
        for (int i = 10; i < 21; i++) {
            integerSet2.insertElement(i);
        }
        unionIntegerSet.setSet(IntegerSet.union(integerSet1.getSet(), integerSet2.getSet()));
        String unionString = "0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 ";
        assertEquals(unionString, unionIntegerSet.toString());
    }

    @Test
    void intersection() {

    }

    @Test
    void testToStringWithEmptySet() {
        IntegerSet integerSet = new IntegerSet();
        assertEquals("---", integerSet.toString());
    }

    @Test
    void testToStringWithInsertedValues() {
        for (int i = 0; i < 21; i++) {
            integerSet.insertElement(i);
        }
        String string = "0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 ";
        assertEquals(string, integerSet.toString());
    }

    @Test
    void isEqual() {
        IntegerSet integerSet1 = new IntegerSet();
        IntegerSet integerSet2 = new IntegerSet();
        for (int i = 0; i < 21; i++) {
            integerSet1.insertElement(i);
            integerSet2.insertElement(i);
        }
        assertTrue(IntegerSet.isEqual(integerSet1.getSet(), integerSet2.getSet()));
    }
}