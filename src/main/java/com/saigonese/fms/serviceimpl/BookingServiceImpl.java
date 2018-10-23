package com.saigonese.fms.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.saigonese.fms.domain.Booking;
import com.saigonese.fms.domain.Flight;
import com.saigonese.fms.repository.BookingRepository;
import com.saigonese.fms.repository.FlightRepository;
import com.saigonese.fms.service.BookingService;
import com.saigonese.fms.service.FlightService;

public class BookingServiceImpl implements BookingService {
	@Autowired
	BookingRepository bookingRepository;

	@Autowired
	FlightService flightService;

	@Override
	public Long saveBooking(Booking booking) {
		Long bookingId = bookingRepository.save(booking);
		return bookingId;
	}

	@Override
	public Flight validateFlight(long flightId) {
		Flight flight = flightService.get(flightId);
		
		if(flight == null) {
			throw new InvalidFlightException(flightId);
		}
		
		if(bookingRepository.getAvailableSeat(flight) <= 0) {
			throw new InvalidFlightException(flightId);
		}
		
		return flight;
}}
