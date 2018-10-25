package com.saigonese.fms.exception;

public class InvalidFlightException extends RuntimeException {
	private static final long serialVersionUID = -5192041563033358491L;
	private String flightId;

	public InvalidFlightException(String flightId) {
		this.flightId = flightId;
	}

	public String getFlightId() {
		return flightId;
	}
}
