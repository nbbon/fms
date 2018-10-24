package com.saigonese.fms.flow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.saigonese.fms.domain.Booking;
import com.saigonese.fms.domain.Flight;
import com.saigonese.fms.service.BookingService;
import com.saigonese.fms.service.FlightService;

@Component
public class BookingFlightControllerHelper {

//	@Autowired
//	BookingService bookingService;
//	
	@Autowired
	FlightService flightService;
	
	public Long saveBooking(Booking booking) {
		return 0L; // bookingService.saveBooking(booking);
	}
	
	public Flight validateFlight(String flightId) {
		System.out.println(flightId);
		return null;//flightService.validateFlight(flightId);
		
	}
	
}
