package com.tokigame.flight.api;

import com.tokigame.flight.model.Flight;
import com.tokigame.flight.model.Flights;
import com.tokigame.flight.service.FlightBookingService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class FlightControllerTest {

    @InjectMocks
    FlightController flightController;

    @Mock
    FlightBookingService flightBookingService;

    @Test
    public void testService() {
        flightController.testService();
    }

    @Test
    public void getArrivalFlightsWithDate_ArrivalFlightsWithDate() {
        //Setup test data
        when(flightBookingService.getArrivalFlightsByPlace(anyString())).thenReturn(mock(ArrayList.class));

        //Call method for testing
        ResponseEntity<Flights> arrivalFlightsWithDateResponse = flightController.getArrivalFlightsWithDate("arrival", "Antalya", null);

        //validate response
        assertEquals(HttpStatus.OK, arrivalFlightsWithDateResponse.getStatusCode());
        assertNotNull(arrivalFlightsWithDateResponse.getBody());
        assertFalse(arrivalFlightsWithDateResponse.getBody().getFlightList().isEmpty());
    }

    @Test
    public void getArrivalFlightsWithDate_ArrivalFlightsWithDate_Noresults() {
        //Setup test data
        when(flightBookingService.getArrivalFlightsByPlace(anyString())).thenReturn(new ArrayList<>());

        //Call method for testing
        ResponseEntity<Flights> arrivalFlightsWithDateResponse = flightController.getArrivalFlightsWithDate("arrival", "Antalya", null);

        //validate response
        assertEquals(HttpStatus.NOT_FOUND, arrivalFlightsWithDateResponse.getStatusCode());
        assertNotNull(arrivalFlightsWithDateResponse.getBody());
        assertTrue(arrivalFlightsWithDateResponse.getBody().getFlightList().isEmpty());
    }

}