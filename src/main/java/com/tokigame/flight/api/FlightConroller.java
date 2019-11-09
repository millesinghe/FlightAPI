package com.tokigame.flight.api;

import com.tokigame.flight.core.DataProcessor;
import com.tokigame.flight.model.flight.FlightData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/flight")
public class FlightConroller {


    //@Autowired
    DataProcessor dataProcessor;

    @GetMapping(path= "/test")
    public String testService() {

        return "Flight API Test Endpoint - Checked and Passed";
    }

    @GetMapping(path= "/")
    public String getFlight() {

        return "Flight API Test Endpoint - Checked and Passed";
    }


}
