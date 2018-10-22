package com.saigonese.fms.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.saigonese.fms.domain.Appointment;
import com.saigonese.fms.domain.Category;
import com.saigonese.fms.domain.Doctor;
import com.saigonese.fms.domain.Patient;
import com.saigonese.fms.domain.Timespan;
import com.saigonese.fms.service.AppointmentService;
import com.saigonese.fms.service.CategoryService;
import com.saigonese.fms.service.DoctorService;
import com.saigonese.fms.service.PatientService;
import com.saigonese.fms.service.TimespanService;

/**
 * 
 * @author Carlos Miguel Valderrama Vega - cvalderramav@gmail.com
 *
 *
 */
@Controller
@RequestMapping("/appointment")
public class AppointmentController {
	
	private static final String PATTERN = "MM/dd/yyyy";
	
	@Autowired
	private AppointmentService appointmentService;

	@Autowired
	private TimespanService timespanService;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private DoctorService doctorService;

	@Autowired
	private PatientService patientService;

	@ModelAttribute("categories")
	public List<Category> getCategories() {
		return categoryService.findAll();
	}

//	@ModelAttribute("doctors")
//	public List<Doctor> getDoctors() {
//		return doctorService.findAll();
//	}

//	@ModelAttribute("timespans")
//	public List<Timespan> getTimespans() {
//		return timespanService.findAll();
//	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addAppointment(@RequestParam(value = "categoryId", required = false) Integer categoryId,
			@RequestParam(value = "doctorId", required = false) Long doctorId,
			@RequestParam(value = "timespanId", required = false) String strTimespanId,
			@RequestParam(value = "date", required = false) String strDate,
			@RequestParam(value = "btnFinalSubmit", required = false) String finalSubmit, RedirectAttributes redirectAttributes,
			Model model) {
		Calendar c = Calendar.getInstance();
		List<String> dates = new ArrayList<String>();
		for (int i = 0; i < 14; i++) {
			c.add(Calendar.DATE, 1);
			dates.add(formatDate(c.getTime()));
		}
		if (strDate == null) {
			strDate = dates.get(0);
		}
		model.addAttribute("dates", dates);
//		categoryId
		model.addAttribute("categoryId", categoryId);
		model.addAttribute("date", strDate);
		
		
//		doctors
		List<Doctor> doctors;
		if (categoryId != null && categoryId > 0) {
			doctors = doctorService.findByCategory(categoryId);
		} else {
			doctors = doctorService.findAll();
		}
		model.addAttribute("doctors", doctors);

		Doctor doctor = null;
		if (doctorId != null && doctorId > 0) {
			doctor = doctorService.findById(doctorId);
		} else {
			if (doctors.size() > 0) {
				doctor = doctors.get(0);
			}
		}
//		doctorId
		model.addAttribute("doctorId", doctorId);
//		timespans
		Date date = null;
		List<Timespan> timespans = null;
		if (doctor != null) {
			timespans = doctor.getAvailableTimespans();
			
			SimpleDateFormat format = new SimpleDateFormat(PATTERN);
			try {
				date = format.parse(strDate);
				timespans = doctor.getAvailableTimespans();
				List<Appointment> appointments = appointmentService.findByDoctorId(doctor.getId());
				List<Integer> occupiedTimespanIds = new ArrayList<>();
				for (int i = 0; i < appointments.size(); i++) {
					Date tmp = appointments.get(i).getDate();
					if (date.getYear() == tmp.getYear() && date.getMonth() == tmp.getMonth() && date.getDate() == tmp.getDate()) {
						occupiedTimespanIds.add(appointments.get(i).getTimeSpan().getId());
					}
				}
//				System.out.println("occupiedTimespanIds" + occupiedTimespanIds);
				for (int i = 0; i < timespans.size(); i++) {
					Timespan t = timespans.get(i);
					if (occupiedTimespanIds.contains(t.getId())) {
						t.setAvailable(false);
					}
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		model.addAttribute("timespans", timespans);
//		timespanId
		int timespanId = 0;
		Timespan timespan = null;
		if (timespans != null && strTimespanId != null && !strTimespanId.isEmpty()) {
			timespanId = Integer.parseInt(strTimespanId);
			for (int i = 0; i < timespans.size(); i++) {
				if (timespans.get(i).getId() == timespanId) {
					timespan = timespans.get(i);
					break;
				}
			}
		}
		if (finalSubmit != null && doctor != null && date != null && timespan != null) {
			Appointment appointment = new Appointment();
			appointment.setDate(toSqlDate(date));
			appointment.setDoctor(doctor);
			appointment.setTimeSpan(timespan);
			appointment.setPatient(getLoggedInPatient());
			appointmentService.save(appointment);
			redirectAttributes.addFlashAttribute("appointment", appointment);
			return "redirect:/appointment/appointment-result";
		} else {
			return "appointment/make-appointment";
		}
	}

	private String formatDate(Date date) {
		SimpleDateFormat format = new SimpleDateFormat(PATTERN);
		return format.format(date);
	}

	@RequestMapping(value = "/appointment-result")
	public String result() {
		return "appointment/appointment-result";
	}

	private Patient getLoggedInPatient() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		return patientService.getPatientByUserName(username);
	}

	private java.sql.Date toSqlDate(Date date) {
		return new java.sql.Date(date.getTime());
	}
}
