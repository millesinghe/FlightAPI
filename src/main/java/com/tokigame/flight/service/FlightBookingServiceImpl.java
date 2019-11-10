package com.tokigame.flight.service;

import com.tokigame.flight.exception.ServiceException;
import com.tokigame.flight.model.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlightBookingServiceImpl implements FlightBookingService {

    @Autowired
    private ExternalFlightService externalFlightService;

    @Override
    public List<Flight> getArrivalFlightsByPlace(String place) {
        try {
            return externalFlightService.getFlightsByPlace("arrival", place);
        } catch (Exception e) {
            throw new ServiceException(e);
        }

    }

    @Override
    public List<Flight> getArrivalFlightsByPlaceAndTime(String place, double time) {
        try {
            return externalFlightService.getFlightsByPlace("arrival", place).stream().filter(x -> time < x.getDepartureTime()).collect(Collectors.toList());
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Flight> getDepartFlightsByPlace(String place) {

        try {
            return externalFlightService.getFlightsByPlace("departure", place);
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Flight> getDepartFlightsByPlaceAndTime(String place, double time) {
        try {
            return externalFlightService.getFlightsByPlace("departure", place).stream().filter(x -> time < x.getDepartureTime()).collect(Collectors.toList());

        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }
}
