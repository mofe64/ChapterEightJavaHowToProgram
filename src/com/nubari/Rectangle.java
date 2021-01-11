package com.nubari;

public class Rectangle {
    double length = 1;
    double width = 1;

    public Rectangle() {
    }

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        if (length > 0.0 && length < 20.0) {
            this.length = length;
        }

    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        if (length > 0.0 && length < 20.0) {
            this.width = width;
        }
    }

    public double calculatePerimeter() {
        return (length + width) * 2;
    }
}
