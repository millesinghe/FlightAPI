package com.tokigame.flight.core;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tokigame.flight.model.flight.BizFlight;
import com.tokigame.flight.model.flight.CheapFlight;
import com.tokigame.flight.model.response.HttpResponse;
import com.tokigame.flight.util.Constant;
import com.tokigame.flight.api.ServiceRequestor;

public class DataExtractor {

	private ServiceRequestor service = null;

	private Stream<BizFlight> resultingStream;

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

	
	private BizFlight[] getCheapFlights() {
		HttpResponse response = service.executorService(Constant.CHEAP_URL);
		BizFlight[] refactCheap = null;
		try {
			CheapFlight[] flight = new ObjectMapper().readValue(new JSONObject(response.getResult()).get("data").toString(), CheapFlight[].class);
			refactCheap = this.refactorFlightList(flight);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		return refactCheap;
	}

	private BizFlight[] refactorFlightList(CheapFlight[] flights) {
		
		ArrayList<BizFlight> bizflight = new ArrayList<BizFlight>();
		BizFlight cheap = null;
		
		for (CheapFlight cheapFlight : flights) {
			cheap = new BizFlight();
			cheap.setArrivalTime(cheapFlight.getArrival());
			cheap.setDepartureTime(cheapFlight.getDeparture());
			cheap.setArrival(cheapFlight.getRoute().split("-")[0]);
			cheap.setDeparture(cheapFlight.getRoute().split("-")[1]);
			cheap.setType("Cheap");
			bizflight.add(cheap);
		}
		
		return bizflight.toArray(new BizFlight[bizflight.size()]);
	}

	private BizFlight[] getBizFlights() {
		HttpResponse response = service.executorService(Constant.BIZ_URL);
		BizFlight[] flight = null;
		try {
			System.out.println();
			flight = new ObjectMapper().readValue(new JSONObject(response.getResult()).get("data").toString(), BizFlight[].class);
		} catch (IOException e) {
			e.printStackTrace();
		};
		return flight;
	}

	public void extractAll() {
		BizFlight[] cheaps = this.getCheapFlights();
		Stream<BizFlight> streamCheaps = Arrays.stream(cheaps);
		
		BizFlight[] biz = this.getBizFlights();
		Stream<BizFlight> streamBiz = Arrays.stream(biz);
		
		//Stream.concat(streamCheaps, streamBiz);
		resultingStream = Stream.concat(streamCheaps, streamBiz);

//		resultingStream.allMatch(null);

	}

	public Stream<BizFlight> getResultingStream() {
		return resultingStream;
	}

	public void setResultingStream(Stream<BizFlight> resultingStream) {
		this.resultingStream = resultingStream;
	}
}
