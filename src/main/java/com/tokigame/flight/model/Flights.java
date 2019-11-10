package com.tokigame.flight.model;

import java.util.List;

public class Flights {

    private List<Flight> flightList;

    private String msg;

    public Flights(List<Flight> flightList) {
        this.flightList = flightList;
    }

    public Flights(String msg) {
        this.flightList = null;
        this.msg = msg;
    }

    public List<Flight> getFlightList() {
        return flightList;
    }

    public void setFlightList(List<Flight> flightList) {
        this.flightList = flightList;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
