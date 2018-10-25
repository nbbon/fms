package com.saigonese.fms.service;

import com.saigonese.fms.domain.Booking;

/**
 * 
 * @author Quang Hiep Nguyen
 *
 */
public interface BookingService {
	public Booking saveBooking(Booking booking);
	public Booking findBookingByCC(String cCode);
	
}
