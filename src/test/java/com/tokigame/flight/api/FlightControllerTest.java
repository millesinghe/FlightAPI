package com.tokigame.flight.api;

import org.junit.Test;
import org.mockito.InjectMocks;

import static org.junit.Assert.*;

public class FlightControllerTest {

    @InjectMocks
    FlightController flightController;

    @Test
    public void testService() {
        flightController.testService();
    }

    @Test
    public void getArrivalFlightsWithDate() {
        flightController.getArrivalFlightsWithDate();
    }
}