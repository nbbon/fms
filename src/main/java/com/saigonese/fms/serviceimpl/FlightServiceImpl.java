package com.saigonese.fms.serviceimpl;

import com.saigonese.fms.domain.Flight;
import com.saigonese.fms.exception.InvalidFlightException;
import com.saigonese.fms.repository.FlightRepository;
import com.saigonese.fms.service.FlightService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FlightServiceImpl implements FlightService {

    @Autowired
    FlightRepository flightRepository;

    @Override
    public List<Flight> findAll() {
        return (List<Flight>) flightRepository.findAll();
    }

    @Override
    public Flight save(Flight flight) {
        return flightRepository.save(flight);
    }

    @Override
    public Flight findOne(Long id) {
        return flightRepository.findOne(id);
    }

    @Override
    public void delete(Long id) {
        flightRepository.delete(id);
    }
    
	@Override
	public Flight validateFlight(String flightId) {
		
		if(flightId == null || flightId.isEmpty()) {
			throw new InvalidFlightException("Invalid flight number" + flightId);
		}
		
		long flightID = Long.parseLong(flightId);
		
		Flight flight = this.findOne(flightID);
		
		if(flight == null) {
			throw new InvalidFlightException("Invalid flight number" + flightId);
		}
		
		return flight;

	}

}
