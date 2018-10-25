package com.saigonese.fms.flow;

import java.util.Date;
import java.util.Random;

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
		booking.setConfirmationCode(getConfirmationCode());
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
	
	protected String getConfirmationCode() {
        String CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        String NUMS = "1234567890";
        StringBuilder stringCode = new StringBuilder();
        Random randomNumber = new Random();
        String source = CHARS;
        while (stringCode.length() < 12) {
            int index = (int) (randomNumber.nextFloat() * source.length());
            stringCode.append(source.charAt(index));
            if(index > 4) {
            	source = NUMS;
            }
        }
        return stringCode.toString();
    }
	
}
