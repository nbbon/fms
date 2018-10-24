package com.saigonese.fms.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.saigonese.fms.domain.Booking;
import com.saigonese.fms.domain.Flight;
import com.saigonese.fms.exception.InvalidFlightException;
import com.saigonese.fms.repository.BookingRepository;
import com.saigonese.fms.repository.FlightRepository;
import com.saigonese.fms.service.BookingService;
import com.saigonese.fms.service.FlightService;

/**
 * 
 * @author Quang Hiep Nguyen
 *
 */

@Service
@Transactional
public class BookingServiceImpl implements BookingService {
	@Autowired
	BookingRepository bookingRepository;


	@Override
	public Booking saveBooking(Booking booking) {
		return bookingRepository.save(booking);
		
	}

	@Override
	public Booking findBookingByCC(String cCode) {
		return bookingRepository.findBookingByConfirmationCode(cCode);
	}

}
