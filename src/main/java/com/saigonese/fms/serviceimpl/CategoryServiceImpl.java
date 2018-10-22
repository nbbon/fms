package com.saigonese.fms.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saigonese.fms.domain.Category;
import com.saigonese.fms.repository.CategoryRepository;
import com.saigonese.fms.service.CategoryService;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public List<Category> findAll() {
		List<Category> list = new ArrayList<>();
		categoryRepository.findAll().forEach((Category c) -> list.add(c));
		return list;
	}

	@Override
	public Category getById(int id) {
		return categoryRepository.findOne(id);
	}

	@Override
	public int save(Category category) {
		return categoryRepository.save(category).getId();
	}

}
