package com.tokigame.flight.model;

import java.io.Serializable;

public class Flight implements Serializable {

    public Flight(String departure, String arrival, String type, int departureTime, int arrivalTime) {
        this.departure = departure;
        this.arrival = arrival;
        this.type = type;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    private String departure;

    private String arrival;

    private String type = "Biz";

    private int departureTime;

    private int arrivalTime;

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public int getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(int departureTime) {
        this.departureTime = departureTime;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
