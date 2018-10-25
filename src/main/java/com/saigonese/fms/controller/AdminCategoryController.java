package com.saigonese.fms.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.saigonese.fms.domain.Airplane;
import com.saigonese.fms.domain.Category;
import com.saigonese.fms.service.AirplaneService;
import com.saigonese.fms.service.CategoryService;

/**
 * 
 * @author Ba Bon Nguyen bnguyen@mum.edu
 *
 *
 */
@Controller
@RequestMapping("/admin/category")
public class AdminCategoryController {
	@Autowired
	AirplaneService airplaneService;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody Airplane addCategory(@Valid @RequestBody Airplane airplane) {
		long airplaneId = airplaneService.saveAirplane(airplane);
		airplane.setId(airplaneId);
		return airplane;
	}
}
