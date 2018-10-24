package com.saigonese.fms.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import com.saigonese.fms.domain.Airline;
import com.saigonese.fms.service.AirlineService;

@Component
public class AirlineFormatter implements Formatter<Airline> {

	@Autowired
	private AirlineService airlineService;

	@Override
	public String print(Airline c, Locale locale) {
		return c.getAirlineName();
	}

	@Override
	public Airline parse(String text, Locale locale) throws ParseException {
		System.out.println("Parsing Airline from: " + text);
		Airline airline = airlineService.findOne(Long.parseLong(text));
		return airline;
	}

}
