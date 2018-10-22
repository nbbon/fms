package com.saigonese.fms.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.saigonese.fms.domain.Category;
import com.saigonese.fms.service.CategoryService;

/**
 * 
 * @author Cong Khanh Tran - trancongkhanh@gmail.com
 *
 *
 */
@Controller
@RequestMapping("/admin/category")
public class AdminCategoryController {
	@Autowired
	CategoryService categoryService;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody Category addCategory(@Valid @RequestBody Category category) {
		int categoryId = categoryService.save(category);
		category.setId(categoryId);
		return category;
	}
}
