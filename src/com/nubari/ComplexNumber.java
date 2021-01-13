package com.nubari;

public class ComplexNumber {

    private double realPart;
    private double imaginaryPart;

    public ComplexNumber(double real, double imaginary) {
        this.realPart = real;
        this.imaginaryPart = imaginary;
    }

    public ComplexNumber() {
    }

    public static ComplexNumber sum(ComplexNumber complexNumber1, ComplexNumber complexNumber2) {
        ComplexNumber temp = new ComplexNumber();
        temp.realPart = complexNumber1.realPart + complexNumber2.realPart;
        temp.imaginaryPart = complexNumber1.imaginaryPart + complexNumber2.imaginaryPart;
        return temp;
    }

    public double getRealPart() {
        return realPart;
    }

    public double getImaginaryPart() {
        return imaginaryPart;
    }

    public void setRealPart(double realPart) {
        this.realPart = realPart;
    }

    public void setImaginaryPart(double imaginaryPart) {
        this.imaginaryPart = imaginaryPart;
    }

    @Override
    public String toString() {
        return realPart + " + " + imaginaryPart + "i";
    }
}
