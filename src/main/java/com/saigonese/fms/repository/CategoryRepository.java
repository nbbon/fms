package com.saigonese.fms.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.saigonese.fms.domain.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer> {

}
