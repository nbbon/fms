package com.saigonese.fms.controller;

import java.util.Set;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

  
@Controller
public class HomeController {
	@RequestMapping({"", "/","/welcome"})
	public String welcome(Model model, Authentication authentication) {
//		model.addAttribute("greeting", "Welcome to ABC Medical Clinic");
		if (authentication != null ) {
			Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
	        if (roles.contains("ROLE_ADMIN")){
	            return "redirect:/admin";
	        }
		}
		return "welcome";
	}
	
	@RequestMapping("/welcome/greeting")
	public String greeting() {
		return "welcome";
	}
	
	@RequestMapping("/test")
	public String test() throws Exception {
		return "home";
	}
}
