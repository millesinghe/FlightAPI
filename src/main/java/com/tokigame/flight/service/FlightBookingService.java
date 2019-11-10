package com.tokigame.flight.service;

import com.tokigame.flight.model.Flight;

import java.util.List;

public interface FlightBookingService {

    List<Flight> getArrivalFlightsByPlace(String place);

    List<Flight> getArrivalFlightsByPlaceAndTime(String place, double time);

    List<Flight> getDepartFlightsByPlace(String place);

    List<Flight> getDepartFlightsByPlaceAndTime(String place, double time);
}
