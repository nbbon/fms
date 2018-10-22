package com.saigonese.fms.serviceimpl;

import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saigonese.fms.domain.Appointment;
import com.saigonese.fms.repository.AppointmentRepository;
import com.saigonese.fms.service.AppointmentService;

/**
 * 
 * @author Cong Khanh Tran - trancongkhanh@gmail.com
 *
 *
 */
@Service
@Transactional
public class AppointmentServiceImpl implements AppointmentService {

	@Autowired
	private AppointmentRepository appointmentRepository;

	@Override
	public List<Appointment> findAll() {
		List<Appointment> list = new ArrayList<>();
		appointmentRepository.findAll().forEach((Appointment a) -> list.add(a));
		return list;
	}

	@Override
	public List<Appointment> findByDoctorId(long doctorId) {
		List<Appointment> all = findAll();
		return all.stream().filter((Appointment a) -> a.getDoctor().getId() == doctorId).collect(Collectors.toList());
	}

	@Override
	public List<Appointment> findByDoctorIdAndDate(Long doctorId, Date date) {
		return appointmentRepository.findByDoctorIdAndDate(doctorId, date);
	}

	@Override
	public Appointment save(Appointment appointment) {
		return appointmentRepository.save(appointment);
		
	}

}
