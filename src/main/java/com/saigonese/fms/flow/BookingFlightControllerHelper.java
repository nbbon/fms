package com.saigonese.fms.flow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.saigonese.fms.domain.Booking;
import com.saigonese.fms.domain.Flight;
import com.saigonese.fms.service.BookingService;

@Component
public class BookingFlightControllerHelper {

	@Autowired
	BookingService bookingFlightService;
	
	public Long saveBooking(Booking booking) {
		return bookingFlightService.saveBooking(booking);
	}
	
	public Flight validateFlight(String flightId) {
		
		return bookingFlightService.validateFlight(flightId);
		
	}
	
}
