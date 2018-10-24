package com.saigonese.fms.controller;

import java.util.List;

import javax.validation.Valid;

import com.saigonese.fms.domain.Airline;
import com.saigonese.fms.domain.Airplane;
import com.saigonese.fms.domain.Airport;
import com.saigonese.fms.domain.Flight;
import com.saigonese.fms.service.AirlineService;
import com.saigonese.fms.service.AirplaneService;
import com.saigonese.fms.service.AirportService;
import com.saigonese.fms.service.FlightService;
import com.saigonese.fms.validator.FlightScheduleValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @author Quang Hiep Nguyen
 *
 */

@Controller
public class FlightController {

	@Autowired
	private FlightService flightService;
	
	@RequestMapping(value = "/flights", method = RequestMethod.GET)
	public String flights(Model model) {		
		model.addAttribute("flights", flightService.findAll());
		return "flight/index";
	}

}
