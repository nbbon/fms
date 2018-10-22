package com.saigonese.fms.service;


import java.util.List;

import com.saigonese.fms.domain.Doctor;
import com.saigonese.fms.domain.Patient;

public interface PatientService {
	long save(Patient patient);
	List<Patient> findAll();
	Patient findPatientById(Long patientId);
	Patient getPatientByUserName(String username);
	public Patient getPatienByEmail(String email);
}
