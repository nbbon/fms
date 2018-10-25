package com.saigonese.fms.service;

import com.saigonese.fms.domain.Flight;

public interface FlightService extends BaseService<Flight> {
	
    public Flight validateFlight(String flightId);

}
