package com.saigonese.fms.controller;

import com.saigonese.fms.domain.Airplane;
import com.saigonese.fms.service.AirplaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/admin/airplane")
public class AirplaneController {

    @Autowired
    private AirplaneService airplaneService;

    @RequestMapping(value={"", "/","/index"}, method=RequestMethod.GET)
    public String airplanes(Model model) {
    	model.addAttribute("airplanes", airplaneService.findAll());
        return "admin/airplane";
    }

    @RequestMapping(value="/new")
	public String newAirplaneForm(Model model){
		model.addAttribute("airplane", new Airplane());
		return "admin/airplane/new";
	}

	@RequestMapping(value = "/new", method=RequestMethod.POST)
	public String addNewAirplane(@Valid @ModelAttribute("airplane") Airplane airplane,
			BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("errors", bindingResult.getAllErrors());
			return "admin/airplane/new";
		}
		airplane = airplaneService.save(airplane);
		return "redirect:/admin/airplane";
	}

    @RequestMapping(value = "/edit/{id}")
    public String get(@PathVariable long id, Model model) {
        model.addAttribute("airplane", this.airplaneService.findOne(id));
        return "admin/airplane/edit";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String update(@PathVariable long id, @Valid @ModelAttribute("airplane") Airplane airplane, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "admin/airplane/edit";
        }
        this.airplaneService.save(airplane); // airline.id already set by binding

        return "redirect:/admin/airplane";
    }
    
    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes="application/json")
	public @ResponseBody Airplane addAirplane(@Valid @RequestBody Airplane airplane) {
		long airplaneId = airplaneService.saveAirplane(airplane);
		airplane.setId(airplaneId);
		return airplane;
	}

}
