package com.tokigame.flight.model.flight;

public class CheapFlight {
	
	private String route;
	
	private String type = "Cheap";
	
	private int departure;

	private int arrival;

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	public int getDeparture() {
		return departure;
	}

	public void setDeparture(int departure) {
		this.departure = departure;
	}

	public int getArrival() {
		return arrival;
	}

	public void setArrival(int arrival) {
		this.arrival = arrival;
	}
	
}
