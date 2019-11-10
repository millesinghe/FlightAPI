package com.tokigame.flight.service;

import com.tokigame.flight.model.Flight;

import java.util.List;

public interface ExternalFlightService {

    List<Flight> getFlightsByPlace(String type, String place);
}
