package com.saigonese.fms.flow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.saigonese.fms.domain.Booking;
import com.saigonese.fms.domain.Flight;
import com.saigonese.fms.service.BookingService;

@Component
public class BookingFlightControllerHelper {

//	@Autowired
//	BookingService bookingService;
//	
	public Long saveBooking(Booking booking) {
		return 0L; // bookingService.saveBooking(booking);
	}
	
	public Flight validateFlight(String flightId) {
		
		return null; //bookingFlightService.validateFlight(flightId);
		
	}
	
}
