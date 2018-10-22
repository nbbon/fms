package com.saigonese.fms.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import com.saigonese.fms.domain.Category;
import com.saigonese.fms.domain.Timespan;
import com.saigonese.fms.service.CategoryService;
import com.saigonese.fms.service.TimespanService;

@Component
public class TimespanFormatter implements Formatter<Timespan> {

	@Autowired
	private TimespanService timespanService;

	@Override
	public String print(Timespan timespan, Locale locale) {
		return timespan.getId() + "";
	}

	@Override
	public Timespan parse(String text, Locale locale) throws ParseException {
		Timespan timespan = timespanService.getById(Integer.parseInt(text));
		return timespan;
	}

}
