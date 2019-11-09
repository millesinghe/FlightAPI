package com.tokigame.flight.model.response;

public class HttpResponse {

	private String getProtocolVersion;
	
	private String getStatusCode;
	
	private String getReasonPhrase;
	
	private String result;

	public String getGetProtocolVersion() {
		return getProtocolVersion;
	}

	public void setGetProtocolVersion(String getProtocolVersion) {
		this.getProtocolVersion = getProtocolVersion;
	}

	public String getGetStatusCode() {
		return getStatusCode;
	}

	public void setGetStatusCode(String getStatusCode) {
		this.getStatusCode = getStatusCode;
	}

	public String getGetReasonPhrase() {
		return getReasonPhrase;
	}

	public void setGetReasonPhrase(String getReasonPhrase) {
		this.getReasonPhrase = getReasonPhrase;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
}
