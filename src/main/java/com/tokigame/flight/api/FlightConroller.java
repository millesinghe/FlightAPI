package com.tokigame.flight.api;

import com.tokigame.flight.core.DataProcessor;
import com.tokigame.flight.model.flight.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class FlightConroller {

    DataProcessor dataProcessor;

    @GetMapping(path= "/test")
    public String testService() {
        return "Flight API Test Endpoint - Checked and Passed";
    }
//, @RequestParam String from, @RequestParam String to, @RequestParam String fromTime, @RequestParam String toTime
    @GetMapping(path= "/{type}")
    public List<Flight> getArrivalFlights(@PathVariable("type") String type, @RequestParam String to,@RequestParam String toTime) {
        dataProcessor = new DataProcessor();
        dataProcessor.getArrivalFlights(to,Integer.parseInt(toTime));
        return null;
    }

}
