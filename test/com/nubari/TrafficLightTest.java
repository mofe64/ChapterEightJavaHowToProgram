package com.nubari;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrafficLightTest {
    TrafficLight trafficLight;
    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void values() {
        for (TrafficLight trafficLight : TrafficLight.values()){
            System.out.println("Color : " + trafficLight + ", duration :" + trafficLight.getTimeLimit());
        }
    }

}