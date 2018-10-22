package com.saigonese.fms.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import com.saigonese.fms.domain.Category;
import com.saigonese.fms.service.CategoryService;

@Component
public class CategoryFormatter implements Formatter<Category> {

	@Autowired
	private CategoryService categoryService;

	@Override
	public String print(Category c, Locale locale) {
		return c.getId() + "";
	}

	@Override
	public Category parse(String text, Locale locale) throws ParseException {
		System.out.println("parse category " + text);
		Category category = categoryService.getById(Integer.parseInt(text));
		return category;
	}

}
