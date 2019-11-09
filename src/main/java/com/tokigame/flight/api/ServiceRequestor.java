package com.tokigame.flight.api;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.tokigame.flight.model.response.HttpResponse;

public class ServiceRequestor {
	
	public HttpResponse executorService(String url) {

		HttpGet request = new HttpGet(url);

		HttpResponse response = new HttpResponse();

		try (CloseableHttpClient httpClient = HttpClients.createDefault();
				CloseableHttpResponse res = httpClient.execute(request)) {

			// Get HttpResponse Status
			response.setGetProtocolVersion(res.getProtocolVersion().getProtocol()); // HTTP/1.1
			response.setGetStatusCode(String.valueOf(res.getStatusLine().getStatusCode())); // 200
			response.setGetReasonPhrase(res.getStatusLine().getReasonPhrase()); // OK

			HttpEntity entity = res.getEntity();
			String result = "";

			if (entity != null) {
				// return it as a String
				result = result + EntityUtils.toString(entity);

			}
			response.setResult(result);	
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return response;
	}
}
