package com.saigonese.fms.service;

import java.util.List;

import com.saigonese.fms.domain.Doctor;

public interface DoctorService {
	long save(Doctor doctor);
	List<Doctor> findAll();
	List<Doctor> findByCategory(int categoryId);
	Doctor findById(long id);
}
