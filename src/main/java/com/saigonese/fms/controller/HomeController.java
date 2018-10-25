package com.saigonese.fms.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.saigonese.fms.domain.Flight;
import com.saigonese.fms.service.FlightService;

  
@Controller
public class HomeController {
	
	@Autowired
	private FlightService flightService;
	
	@ModelAttribute("flights")
	private List<Flight> flights() {
		return flightService.findAll();
	}
	
	@RequestMapping({"", "/","/welcome"})
	public String welcome(Authentication authentication) {
//		model.addAttribute("flights", flightService.findAll());
		if (authentication != null ) {
			
			Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
	        if (roles.contains("ROLE_ADMIN")){
	            return "redirect:/admin";
	        }
		}
		return "redirect:/flights";
	}
	
	@RequestMapping(value = {"/admin", "/admin/", "/admin/index"}, method = RequestMethod.GET)
	public String admin() {
		
		return "redirect:/admin/flight";
	}
}
