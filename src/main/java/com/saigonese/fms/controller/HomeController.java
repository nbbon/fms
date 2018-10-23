package com.saigonese.fms.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.saigonese.fms.service.FlightService;

  
@Controller
public class HomeController {
	
	@Autowired
	private FlightService flightService;
	
	@RequestMapping({"", "/","/welcome"})
	public String welcome(Model model, Authentication authentication) {
		model.addAttribute("flights", flightService.findAll());
		if (authentication != null ) {
			Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
	        if (roles.contains("ROLE_ADMIN")){
	            return "redirect:/admin";
	        }
		}
		return "redirect:/flights";
	}
}
