package com.saigonese.fms.flow;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.saigonese.fms.domain.Booking;
import com.saigonese.fms.domain.Flight;
import com.saigonese.fms.service.BookingService;
import com.saigonese.fms.service.FlightService;

/**
 * 
 * @author Quang Hiep Nguyen
 *
 */
@Component
public class BookingFlightControllerHelper {

	@Autowired
	BookingService bookingService;
	
	@Autowired
	FlightService flightService;
	
	public long saveBooking(Booking booking) {
		booking.setConfirmationCode("BBB12345");
		booking.setBookingDate(new Date());
		Booking booked = bookingService.saveBooking(booking);
		if(booked != null)
			return booked.getId();
		return 0L;
	}
	
	public Flight validateFlight(String flightId) {		
		Flight f = flightService.validateFlight(flightId);
		System.out.println(f.toString());
		return f;
		
	}
	
}
