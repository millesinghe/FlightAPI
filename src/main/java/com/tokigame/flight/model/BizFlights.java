package com.tokigame.flight.model;

import java.util.ArrayList;

public class BizFlights {

    private ArrayList<BizFlightResponse> data = new ArrayList<BizFlightResponse>();

    public ArrayList<BizFlightResponse> getData() {
        return data;
    }

    public void setData(ArrayList<BizFlightResponse> data) {
        this.data = data;
    }
}
