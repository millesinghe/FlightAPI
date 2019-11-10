package com.tokigame.flight.core;

import com.tokigame.flight.model.flight.Flight;

import java.util.List;
import java.util.stream.Collectors;

public class ArrivalProcessor extends DataProcessor {

    public List<Flight>  getArrivalFlights(String toPlace){
        List<Flight> flights = dataExtractor.getFlightList();

        List<Flight> result = flights.stream().filter(x ->toPlace.equals(x.getArrival())).collect(Collectors.toList());

        return result;
    }

    public List<Flight>  getArrivalFlights(String toPlace, double toTime){
        List<Flight> flights = dataExtractor.getFlightList();

        List<Flight> result = flights.stream().filter(x ->toPlace.equals(x.getArrival()) && ((int)toTime) < x.getArrivalTime() ).collect(Collectors.toList());

        return result;
    }
}
