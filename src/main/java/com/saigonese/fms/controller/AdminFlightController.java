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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/admin/flight")
public class AdminFlightController {

	@Autowired
	private FlightService flightService;

	@Autowired
	private AirportService airportService;

	@Autowired
	private AirlineService airlineService;

	@Autowired
	private AirplaneService airplaneService;
	
	@RequestMapping(value={"", "/","/index"}, method = RequestMethod.GET)
	public String flights(Model model) {
		model.addAttribute("flights", flightService.findAll());
		return "admin/flight";
	}

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String newFlightForm(@ModelAttribute("flight")Flight flight, Model model){
		model.addAttribute("airlines", airlineService.findAll());
		model.addAttribute("airplanes", airplaneService.findAll());
		model.addAttribute("airports", airportService.findAll());
		return "admin/flight/new";
	}

	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public String scheduleNewFlight(@Valid @ModelAttribute("flight") Flight flight,
			BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("errors", bindingResult.getAllErrors());
			return "admin/flight/new";
		}
		flight = flightService.save(flight);
		return "redirect:/admin/flight";
	}

	@RequestMapping(value = "/admin/flight/{id}", method = RequestMethod.GET)
	public String get(@PathVariable Long id, Model model){
		Flight flight = flightService.findOne(id);
		if (flight != null) {
			model.addAttribute("flight", flight);
			model.addAttribute("airlines", airlineService.findAll());
			model.addAttribute("airplanes", airplaneService.findAll());
			model.addAttribute("airports", airportService.findAll());
			return "admin/flight/edit";
		}
		
		return "admin/flights";
	}

/*	@RequestMapping(value= "/flight", method = RequestMethod.POST)
	public String editFlight(@Valid @ModelAttribute("flight") Flight flight,
							 BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("errors", bindingResult.getAllErrors());
			return "/flight/edit";
		}
		flightService.save(flight); // flight.id already set by binding
		return "redirect:/";
	}*/

	// Only search by departure date
//	@PostMapping(value = "/flight/search")
//	@RequestMapping(value= "/flight", method = RequestMethod.POST)
//	public String defaultSearchForFlights(@RequestParam String criteria, Model model) {
//		model.addAttribute("flights", flightService.search(criteria));
//		return "/flight/search";
//	}
}
