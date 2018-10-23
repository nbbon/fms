package com.saigonese.fms.controller;

import com.saigonese.fms.domain.Airline;
import com.saigonese.fms.domain.Airplane;
import com.saigonese.fms.service.AirlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/admin/airline")
public class AirlineController{

    @Autowired
    private AirlineService airlineService;

    @RequestMapping(value={"", "/","/index"}, method=RequestMethod.GET)
    public String airlines(Model model) {
    	model.addAttribute("airlines", airlineService.findAll());
        return "admin/airline";
    }

    @RequestMapping(value = "/new", method=RequestMethod.GET)
    public String newAirlineForm(@ModelAttribute("airline") Airline airline, Model model) {
    	model.addAttribute("airline", new Airline());
    	return "admin/airline/new";
    }

    @RequestMapping(value = "/new", method=RequestMethod.POST)
    public String addNewAirline(@Valid @ModelAttribute("airline") Airline airline,
                                 BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "admin/airline/new";
        }
        airline = airlineService.save(airline);
        return "redirect:/admin/airline";
    }

    @RequestMapping(value = "/edit/{id}")
    public String get(@PathVariable long id, Model model) {
        model.addAttribute("airline", this.airlineService.findOne(id));
        return "admin/airline/edit";
    }

    @RequestMapping(value = "/edit/{id}", method=RequestMethod.POST)
    public String update(@PathVariable long id, @Valid @ModelAttribute("airline")  Airline airline, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "admin/airline/edit";
        }

        airlineService.save(airline); // airline.id already set by binding
        return "redirect:/admin/airline";
    }


}
