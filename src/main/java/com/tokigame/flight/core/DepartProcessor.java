package com.tokigame.flight.core;

import com.tokigame.flight.model.flight.Flight;

import java.util.List;
import java.util.stream.Collectors;

public class DepartProcessor extends DataProcessor {

    public List<Flight>  getDepartFlights(String toPlace){
        List<Flight> flights = dataExtractor.getFlightList();

        List<Flight> result = flights.stream().filter(x ->toPlace.equals(x.getDeparture())).collect(Collectors.toList());

        return result;
    }

    public List<Flight>  getDepartFlights(String toPlace, double toTime){
        List<Flight> flights = dataExtractor.getFlightList();

        List<Flight> result = flights.stream().filter(x ->toPlace.equals(x.getDeparture()) && ((int)toTime) < x.getDepartureTime() ).collect(Collectors.toList());

        return result;
    }
}
