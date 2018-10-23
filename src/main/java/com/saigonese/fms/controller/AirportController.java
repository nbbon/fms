package com.saigonese.fms.controller;

import com.saigonese.fms.domain.Airport;
import com.saigonese.fms.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = "/admin/airport")
public class AirportController {

    @Autowired
    private AirportService airportService;

    @RequestMapping(value = "", method = RequestMethod.GET)
	public String flights(Model model) {
		model.addAttribute("airports", airportService.findAll());
		return "admin/airport";
	}
    
    @RequestMapping(value="/new", method = RequestMethod.GET)
	public String newAirplaneForm(Model model){
		model.addAttribute("airport", new Airport());
		return "admin/airport/new";
	}

	@RequestMapping(value = "/new", method=RequestMethod.POST)
	public String addNewAirplane(@Valid @ModelAttribute("airport") Airport airport,
			BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("errors", bindingResult.getAllErrors());
			return "admin/airport/new";
		}
		airport = airportService.save(airport);
		return "redirect:/admin/airport";
	}

    @RequestMapping(value = "/edit/{id}", method=RequestMethod.GET)
    public String get(@PathVariable("id")Long id, Model model) {
        model.addAttribute("airport", this.airportService.findOne(id));
        return "admin/airport/edit";
    }

    @RequestMapping(value = "/edit/{id}", method=RequestMethod.POST)
    public String update(@PathVariable long id, @Valid @ModelAttribute("airport") Airport airport, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "admin/airport/edit";
        }
        this.airportService.save(airport); // airport.id already set by binding

        return "redirect:/admin/airport";
    }
}
