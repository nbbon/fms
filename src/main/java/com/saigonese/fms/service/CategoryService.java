package com.saigonese.fms.service;

import java.util.List;

import com.saigonese.fms.domain.Category;

public interface CategoryService {
	List<Category> findAll();

	Category getById(int id);

	int save(Category category);
}
