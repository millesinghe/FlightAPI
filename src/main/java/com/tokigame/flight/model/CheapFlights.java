package com.tokigame.flight.model;

import java.util.ArrayList;

public class CheapFlights {

    private ArrayList<CheapFlightResponse> data = new ArrayList<CheapFlightResponse>();

    public ArrayList<CheapFlightResponse> getData() {
        return data;
    }

    public void setData(ArrayList<CheapFlightResponse> data) {
        this.data = data;
    }
}
