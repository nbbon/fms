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
		
		booking.setConfirmationCode(this.generateCCode(8));
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
	
	private String generateCCode(int len) 
    {  
        // A strong password has Cap_chars, Lower_chars, 
        // numeric value and symbols. So we are using all of 
        // them to generate our password 
        String Capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; 
        String Small_chars = "abcdefghijklmnopqrstuvwxyz"; 
        String numbers = "0123456789";   
  
  
        String values = Capital_chars + Small_chars + numbers;
  
        // Using random method 
        Random rndm_method = new Random(); 
  
        char[] password = new char[len]; 
  
        for (int i = 0; i < len; i++) 
        { 
            // Use of charAt() method : to get character value 
            // Use of nextInt() as it is scanning the value as int 
            password[i] = 
              values.charAt(rndm_method.nextInt(values.length())); 
  
        } 
        return password.toString().substring(1); 
    } 
	
}
