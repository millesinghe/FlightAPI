package com.tokigame.flight.service;

import com.tokigame.flight.exception.ServiceException;
import com.tokigame.flight.model.Flight;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class FlightBookingServiceImplTest {

    @InjectMocks
    FlightBookingServiceImpl flightBookingService;

    @Mock
    ExternalFlightService externalFlightService;

    @Test
    public void getArrivalFlightsByPlace() {

        when(externalFlightService.getFlightsByPlace(anyString(), anyString())).thenReturn(mock(ArrayList.class));

        List<Flight> flightsByPlace = flightBookingService.getArrivalFlightsByPlace("SG");

        assertTrue(!flightsByPlace.isEmpty());
    }

    @Test(expected = ServiceException.class)
    public void getArrivalFlightsByPlace_Error() {
            when(externalFlightService.getFlightsByPlace(anyString(), anyString())).thenThrow(new ServiceException(any()));

            List<Flight> flightsByPlace = flightBookingService.getArrivalFlightsByPlace("SG");
    }

    @Test
    public void getArrivalFlightsByPlaceAndTime() {
    }

    @Test
    public void getDepartFlightsByPlace() {
    }

    @Test
    public void getDepartFlightsByPlaceAndTime() {
    }
}
