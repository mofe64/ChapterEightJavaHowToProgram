package com.nubari;

public enum TrafficLight {
    RED(30),
    YELLOW(30),
    GREEN(30);
    private final int timeLimit;

    TrafficLight(int seconds) {
        this.timeLimit = seconds;
    }

    public int getTimeLimit() {
        return timeLimit;
    }
}
