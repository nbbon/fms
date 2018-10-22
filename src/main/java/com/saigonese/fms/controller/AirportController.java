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
@RequestMapping(value = "/airport")
public class AirportController {

    @Autowired
    private AirportService airportService;

    @RequestMapping(value={"", "/"}, method=RequestMethod.GET)
    public String defaultPath() {
        return "redirect:/airport/index";
    }

    @RequestMapping(value="/index")
    public ModelAndView getAll() {
        ModelAndView mav = new ModelAndView();
        List<Airport> airports = airportService.findAll();

        mav.addObject("airports", airports);
        mav.setViewName("/airport/index");
        return mav;
    }

    @RequestMapping(value="/new")
	public String newAirplaneForm(Model model){
		model.addAttribute("airport", new Airport());
		return "/airport/new";
	}

	@RequestMapping(value = "/new", method=RequestMethod.POST)
	public String addNewAirplane(@Valid @ModelAttribute("airport") Airport airport,
			BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("errors", bindingResult.getAllErrors());
			return "/airport/new";
		}
		airport = airportService.save(airport);
		return "redirect:/airport";
	}

    @RequestMapping(value = "/{id}")
    public String get(@PathVariable long id, Model model) {
        model.addAttribute("airport", this.airportService.findOne(id));
        return "/airport/detail";
    }

    @RequestMapping(value = "/{id}", method=RequestMethod.POST)
    public String update(@PathVariable long id, @RequestParam("update") String update, @Valid @ModelAttribute("airport") Airport airport, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "/airport/detail";
        }
        this.airportService.save(airport); // airport.id already set by binding

        return "redirect:/airport";
    }

//    @RequestMapping(value = "/{id}", method=RequestMethod.POST)
//    public String delete(@PathVariable long id, @RequestParam("delete") String delete) {
//        this.airportService.delete(id);
//        return "redirect:/airport";
//    }
}
