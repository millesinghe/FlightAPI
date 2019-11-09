package com.tokigame.flight.core;

import com.tokigame.flight.model.flight.BizFlight;
import com.tokigame.flight.model.flight.Flight;

import java.util.List;
import java.util.stream.Stream;

public class DataProcessor {

    private DataExtractor dataExtractor;

    public DataProcessor() {
        dataExtractor = DataExtractor.getInstance();
    }

    public void getArrivalFlights(String to, int toTime){
        List<BizFlight> flights = dataExtractor.getFlightList();

        BizFlight result1 = flights.stream()                        // Convert to steam
                .filter(x -> "jack".equals(x.getArrivalTime()))        // we want "jack" only
                .findAny()                                      // If 'findAny' then return found
                .orElse(null);                                  // If not found, return null

        System.out.println(result1);
        System.out.printf("get Arrival");

        return;
    }

    public void getDepartFlights(Flight flightData){

        System.out.printf("get Depart");

        return;
    }

}
