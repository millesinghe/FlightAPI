package com.tokigame.flight.core;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tokigame.flight.model.flight.Flight;
import com.tokigame.flight.model.flight.CheapFlight;
import com.tokigame.flight.model.response.HttpResponse;
import com.tokigame.flight.util.Constant;
import com.tokigame.flight.api.ServiceRequestor;

public class DataExtractor {

	private ServiceRequestor service = null;

	private List<Flight> flightList;

	private static DataExtractor extractor = null;

	private DataExtractor(){
		service = new ServiceRequestor();
	}

	public static DataExtractor getInstance(){
		if(extractor == null){
			extractor = new DataExtractor();
		}

		return extractor;
	}

	
	private Flight[] getCheapFlights() {
		HttpResponse response = service.executorService(Constant.SERVER_HOST+Constant.CHEAP_URL);
		Flight[] refactCheap = null;
		try {
			CheapFlight[] flight = new ObjectMapper().readValue(new JSONObject(response.getResult()).get("data").toString(), CheapFlight[].class);
			refactCheap = this.refactorFlightList(flight);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		return refactCheap;
	}

	private Flight[] refactorFlightList(CheapFlight[] flights) {
		
		ArrayList<Flight> bizflight = new ArrayList<Flight>();
		Flight cheap = null;
		
		for (CheapFlight cheapFlight : flights) {
			cheap = new Flight();
			cheap.setArrivalTime(cheapFlight.getArrival());
			cheap.setDepartureTime(cheapFlight.getDeparture());
			cheap.setArrival(cheapFlight.getRoute().split("-")[0]);
			cheap.setDeparture(cheapFlight.getRoute().split("-")[1]);
			cheap.setType("Cheap");
			bizflight.add(cheap);
		}
		
		return bizflight.toArray(new Flight[bizflight.size()]);
	}

	private Flight[] getBizFlights() {
		HttpResponse response = service.executorService(Constant.SERVER_HOST+Constant.BIZ_URL);
		Flight[] flight = null;
		try {
			System.out.println();
			flight = new ObjectMapper().readValue(new JSONObject(response.getResult()).get("data").toString(), Flight[].class);
		} catch (IOException e) {
			e.printStackTrace();
		};
		return flight;
	}

	public void extractAll() {
		Flight[] cheaps = this.getCheapFlights();
		Stream<Flight> streamCheaps = Arrays.stream(cheaps);
		
		Flight[] biz = this.getBizFlights();
		Stream<Flight> streamBiz = Arrays.stream(biz);
		
		//Stream.concat(streamCheaps, streamBiz);
		flightList =  Stream.concat(streamCheaps, streamBiz).collect(Collectors.toList());
//		resultingStream.allMatch(null);

	}

	public List<Flight> getFlightList() {
		return flightList;
	}

	public void setFlightList(List<Flight> flightList) {
		this.flightList = flightList;
	}
}
