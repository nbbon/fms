package com.saigonese.fms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.saigonese.fms.service.FlightService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private FlightService flightService;
	
	@RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("flights", flightService.findAll());
		return "admin/flight";
	}
}
