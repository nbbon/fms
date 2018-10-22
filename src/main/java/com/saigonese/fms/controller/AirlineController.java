package com.saigonese.fms.controller;

import com.saigonese.fms.domain.Airline;


import com.saigonese.fms.service.AirlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/airline")
public class AirlineController{

    @Autowired
    private AirlineService airlineService;

    @RequestMapping(value={"", "/"}, method=RequestMethod.GET)
    public String defaultPath() {
        return "redirect:/airline/index";
    }

    @RequestMapping(value = "/index", method=RequestMethod.GET)
    public String getAll(Model model) {
    	model.addAttribute("airlines", airlineService.findAll());
        return "/airline/index";
    }

    @RequestMapping(value = "/new", method=RequestMethod.GET)
    public String newAirlineForm(@ModelAttribute("airline") Airline airline) {
        return "/airline/new";
    }

    @RequestMapping(value = "/new", method=RequestMethod.POST)
    public String addNewAirline(@Valid @ModelAttribute("airline") Airline airline,
                                 BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "/airpline/new";
        }
        airline = airlineService.save(airline);
        return "redirect:/airline";
    }

    @RequestMapping(value = "/{id}")
    public String get(@PathVariable long id, Model model) {
        model.addAttribute("airline", this.airlineService.findOne(id));
        return "/airline/detail";
    }

    @RequestMapping(value = "/{id}", method=RequestMethod.POST)
    public String update(@PathVariable long id, @RequestParam("update") String update, @Valid @ModelAttribute("airline")  Airline airline, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "/airline/detail";
        }

        airlineService.save(airline); // airline.id already set by binding
        return "redirect:/airline";
    }

//    @PostMapping(value = "/{id}", params = "delete")
//    @RequestMapping(value = "/{id}", method=RequestMethod.POST)
//    public String delete(@PathVariable long id, @RequestParam("delete") String delete) {
//        airlineService.delete(id);
//        return "redirect:/airline";
//    }

}
