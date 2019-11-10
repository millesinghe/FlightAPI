package com.tokigame.flight.api;

import com.tokigame.flight.model.Flight;
import com.tokigame.flight.model.Flights;
import com.tokigame.flight.service.FlightBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(path = "/flight")
public class FlightController {

    @Autowired
    private FlightBookingService flightBookingService;


    @GetMapping(path = "/test")
    public String testService() {
        return "Flight API Test Endpoint - Checked and Passed";
    }

    @GetMapping(path = "{type}")
    public ResponseEntity<Flights> getArrivalFlightsWithDate(@PathVariable("type") String type, @RequestParam String toPlace, @RequestParam(value = "toTime", required = false) String toTime) {
        List<Flight> flightList = null;

        switch (type) {
            case "arrival":
                if (Objects.nonNull(toTime)) {
                    flightList = flightBookingService.getArrivalFlightsByPlaceAndTime(toPlace, Double.parseDouble(toTime));
                } else {
                    flightList = flightBookingService.getArrivalFlightsByPlace(toPlace);
                }
                break;

            case "departure":
                if (Objects.nonNull(toTime)) {
                    flightList = flightBookingService.getDepartFlightsByPlaceAndTime(toPlace, Double.parseDouble(toTime));
                } else {
                    flightList = flightBookingService.getDepartFlightsByPlace(toPlace);
                }
                break;
            default:
                return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(new Flights("Type Not Available"));
        }


        if (CollectionUtils.isEmpty(flightList)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Flights(flightList));

        }
        return ResponseEntity.status(HttpStatus.OK).body(new Flights(flightList));
    }

}
