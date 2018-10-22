package com.saigonese.fms.controller;

import com.saigonese.fms.domain.Airplane;
import com.saigonese.fms.service.AirplaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(value = "/airplane")
public class AirplaneController {

    @Autowired
    private AirplaneService airplaneService;

    @RequestMapping(value={"", "/"}, method=RequestMethod.GET)
    public String defaultPath() {
        return "redirect:/airplane/index";
    }

    @RequestMapping(value="/index")
    public ModelAndView getAll() {
        ModelAndView mav = new ModelAndView();
        List<Airplane> airplanes = airplaneService.findAll();

        mav.addObject("airplanes", airplanes);
        mav.setViewName("/airplane/index");
        return mav;
    }

    @RequestMapping(value="/new")
	public String newAirplaneForm(Model model){
		model.addAttribute("airplane", new Airplane());
		return "/airplane/new";
	}

	@RequestMapping(value = "/new", method=RequestMethod.POST)
	public String addNewAirplane(@Valid @ModelAttribute("airplane") Airplane airplane,
			BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("errors", bindingResult.getAllErrors());
			return "/airplane/new";
		}
		airplane = airplaneService.save(airplane);
		return "redirect:/airplane";
	}

    @RequestMapping(value = "/{id}")
    public String get(@PathVariable long id, Model model) {
        model.addAttribute("airplane", this.airplaneService.findOne(id));
        return "/airplane/detail";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public String update(@PathVariable long id, @RequestParam("update") String update, @Valid @ModelAttribute("airplane") Airplane airplane, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "/airplane/detail";
        }
        this.airplaneService.save(airplane); // airline.id already set by binding

        return "redirect:/airplane";
    }

//    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
//    public String delete(@PathVariable long id, @RequestParam("delete") String delete) {
//        this.airplaneService.delete(id);
//        return "redirect:/airplane";
//    }
}
