package com.tokigame.flight.util;

public enum FlightType {
    ARRIVAL("arrival"),
    DEPARTURE("departure");

    public final String type;

    FlightType(String type) {
        this.type = type;
    }

    public String value() {
        return this.type;
    }
}
