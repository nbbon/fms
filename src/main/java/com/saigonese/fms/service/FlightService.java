package com.saigonese.fms.service;

import com.saigonese.fms.domain.Flight;

import java.util.List;

public interface FlightService extends BaseService<Flight> {
	
    List<Flight> search(String criteria);
    public Flight validateFlight(long flightId);

}
