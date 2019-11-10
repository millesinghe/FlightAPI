package com.tokigame.flight.model;

public class CheapFlightResponse {

    private String route;
    private int departure;
    private int arrival;


    // Getter Methods

    public String getRoute() {
        return route;
    }

    public int getDeparture() {
        return departure;
    }

    public int getArrival() {
        return arrival;
    }

    // Setter Methods

    public void setRoute(String route) {
        this.route = route;
    }

    public void setDeparture(int departure) {
        this.departure = departure;
    }

    public void setArrival(int arrival) {
        this.arrival = arrival;
    }

    public String getArrivalCity() {
        return getRoute().split("-")[0];
    }

    public String getDepartureCity() {
        return getRoute().split("-")[1];
    }
}
