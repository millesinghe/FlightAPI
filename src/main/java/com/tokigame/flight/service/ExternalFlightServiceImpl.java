package com.tokigame.flight.service;

import com.tokigame.flight.model.BizFlights;
import com.tokigame.flight.model.CheapFlights;
import com.tokigame.flight.model.Flight;
import com.tokigame.flight.util.Constant;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExternalFlightServiceImpl implements ExternalFlightService {

    @Override
    @Cacheable(value = "flights", key = "{#type, #place}")
    public List<Flight> getFlightsByPlace(String type, String place) {
        RestTemplate restTemplate = new RestTemplate();
        CheapFlights responseCheap = restTemplate.getForObject(Constant.SERVER_HOST + Constant.CHEAP_URL, CheapFlights.class);
        BizFlights responseBiz = restTemplate.getForObject(Constant.SERVER_HOST + Constant.BIZ_URL, BizFlights.class);
        List<Flight> flights = new ArrayList<>();
        responseCheap.getData().stream()
                .map(res -> new Flight(res.getDepartureCity(), res.getArrivalCity(), "cheap", res.getArrival(), res.getDeparture())).filter(x -> (type.equals("departure") && place.equals(x.getDeparture())) || (type.equals("arrival") && place.equals(x.getArrival()))).forEach(flights::add);
        responseBiz.getData().stream()
                .map(res -> new Flight(res.getDeparture(), res.getArrival(), "biz", res.getArrivalTime(), res.getDepartureTime())).filter(x -> (type.equals("departure") && place.equals(x.getDeparture())) || (type.equals("arrival") && place.equals(x.getArrival()))).forEach(flights::add);
        return flights;
    }
}
