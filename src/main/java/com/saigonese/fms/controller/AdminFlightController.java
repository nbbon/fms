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
	
	@ModelAttribute("airlines")
	private List<Airline> getAirlines(){
		return airlineService.findAll();
	}
	
	@ModelAttribute("airports")
	private List<Airport> getAirports(){
		return airportService.findAll();
	}
	
	@ModelAttribute("airplanes")
	private List<Airplane> getAirplanes(){
		return airplaneService.findAll();
	}

	@RequestMapping(value={"", "/","/index"}, method = RequestMethod.GET)
	public String flights(Model model) {
		model.addAttribute("flights", flightService.findAll());
		return "admin/flight";
	}

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String newFlightForm(@ModelAttribute("flight")Flight flight, Model model){
		
		return "admin/flight/new";
	}

	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public String scheduleNewFlight(@Valid @ModelAttribute("flight") Flight flight,
			BindingResult bindingResult, Model model) {
		
		FlightScheduleValidator fsv = new FlightScheduleValidator();
		fsv.validate(flight, bindingResult);
		
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
			return "admin/flight/edit";
		}
		
		return "admin/flights";
	}
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String get(@PathVariable long id, Model model) {
        model.addAttribute("flight", this.flightService.findOne(id));
        return "admin/flight/edit";
    }
	
	@RequestMapping(value= "/edit/{id}", method = RequestMethod.POST)
	public String editFlight(@Valid @ModelAttribute("flight") Flight flight,
							 BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("errors", bindingResult.getAllErrors());
			return "admin/flight/edit";
		}
		flightService.save(flight); // flight.id already set by binding
		return "redirect:/admin/flight";
	}

}
