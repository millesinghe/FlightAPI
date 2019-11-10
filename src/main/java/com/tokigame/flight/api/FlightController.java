package com.tokigame.flight.api;

import com.tokigame.flight.core.ArrivalProcessor;
import com.tokigame.flight.core.DataProcessor;
import com.tokigame.flight.core.DepartProcessor;
import com.tokigame.flight.model.flight.Flight;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class FlightController {

    DataProcessor dataProcessor;

    @GetMapping(path= "/test")
    public String testService() {
        return "Flight API Test Endpoint - Checked and Passed";
    }

    // Sample URL -
    @GetMapping(path= "/{type}")
    public List<Flight> getArrivalFlights(@PathVariable("type") String type, @RequestParam String toPlace) {
        List<Flight> _ret  = null;
        if(type.equals("arrival")) {
            dataProcessor = new ArrivalProcessor();
            _ret  =   ((ArrivalProcessor) dataProcessor).getArrivalFlights(toPlace);
        } else if(type.equals("departure")) {
            dataProcessor = new DepartProcessor();
            _ret  =   ((DepartProcessor) dataProcessor).getDepartFlights(toPlace);
        }
        return _ret;
    }

    // Sample URL -
    @GetMapping(path= "date/{type}")
    public List<Flight> getArrivalFlightsWithDate(@PathVariable("type") String type, @RequestParam String toPlace, @RequestParam String toTime) {
        List<Flight> _ret  = null;
        if(type.equals("arrival")) {
            dataProcessor = new ArrivalProcessor();
            _ret  =   ((ArrivalProcessor) dataProcessor).getArrivalFlights(toPlace, Double.parseDouble(toTime));
        } else if(type.equals("departure")) {
            dataProcessor = new DepartProcessor();
            _ret  =   ((DepartProcessor) dataProcessor).getDepartFlights(toPlace, Double.parseDouble(toTime));
        }
        return _ret;
    }

}
