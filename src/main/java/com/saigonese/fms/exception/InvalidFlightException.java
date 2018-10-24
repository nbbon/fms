package com.saigonese.fms.exception;

public class InvalidFlightException extends RuntimeException {
	private static final long serialVersionUID = -5192041563033358491L;
	private long flightId;

	public InvalidFlightException(long flightId) {
		this.flightId = flightId;
	}

	public long getCartId() {
		return flightId;
	}
}
