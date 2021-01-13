package com.nubari;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComplexNumberTest {
    ComplexNumber complexNumber ;
    @BeforeEach
    void setUp() {
        complexNumber = new ComplexNumber();
    }

    @AfterEach
    void tearDown() {
    }
    @Test
    void testThatComplexNumberCanBeInitializedWithBothRealAndImaginaryValues(){
        ComplexNumber complexNumber = new ComplexNumber(5,19);
        assertEquals(5.0, complexNumber.getRealPart());
        assertEquals(19.0, complexNumber.getImaginaryPart());
    }

    @Test
    void testThatComplexNumberCanSetValuesToDesiredValues(){
        complexNumber.setImaginaryPart(10);
        assertEquals(10,complexNumber.getImaginaryPart());
        complexNumber.setImaginaryPart(5.8);
        assertEquals(5.8, complexNumber.getImaginaryPart());
        complexNumber.setRealPart(4);
        assertEquals(4,complexNumber.getRealPart());
        complexNumber.setRealPart(8.9);
        assertEquals(8.9, complexNumber.getRealPart());
    }

    @Test
    void testThatComplexNumberStaticMethodSumCalculatesTheSumOfTwoComplexNumbers(){
        ComplexNumber complexNumber1 = new ComplexNumber(10,7);
        ComplexNumber complexNumber2 = new ComplexNumber(4,2);
       ComplexNumber sumValue =  ComplexNumber.sum(complexNumber1,complexNumber2);
       assertEquals("14.0 + 9.0i", sumValue.toString());

    }
}