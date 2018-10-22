package com.saigonese.fms.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.saigonese.fms.domain.Category;
import com.saigonese.fms.domain.Doctor;
import com.saigonese.fms.domain.Timespan;
import com.saigonese.fms.service.CategoryService;
import com.saigonese.fms.service.DoctorService;
import com.saigonese.fms.service.TimespanService;

/**
 * 
 * @author Cong Khanh Tran - trancongkhanh@gmail.com
 *
 *
 */
@Controller
@RequestMapping("/admin/doctors")
public class AdminDoctorController {
	@Autowired
	private TimespanService timespanService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private DoctorService doctorService;
	
	@ModelAttribute("categories")
	public List<Category> getCategories() {
		return categoryService.findAll();
	}
	
	@ModelAttribute("timespans")
	public List<Timespan> getTimespans() {
		return timespanService.findAll();
	}

	@Autowired
	private ServletContext servletContext;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listDoctors(Model model) {
		List<Doctor> doctorList = doctorService.findAll();
		model.addAttribute("doctors", doctorList);
		return "admin/doctor_list";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addDoctor(@ModelAttribute("doctor") Doctor doctor, Model model) {
//		doctor.setAvailableTimespans((List<Timespan>)model.asMap().get("timespans"));
		return "admin/add_doctor";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String saveDoctor(@ModelAttribute("doctor") @Valid Doctor doctor, BindingResult bindingResult, RedirectAttributes redirectAttributes) throws IOException {
		
		if (bindingResult.hasErrors()) {
			return "admin/add_doctor";
		}
		long doctorId = doctorService.save(doctor);
		MultipartFile doctorPicture = doctor.getPicture();
		if (doctorPicture != null && !doctorPicture.isEmpty()) {
			savePicture(doctorId, doctorPicture);
		}
//		Process file upload
		redirectAttributes.addFlashAttribute("doctor", doctor);
		return "redirect:details";
	}

	private void savePicture(long id, MultipartFile doctorPicture) throws IOException {
		String rootDirectory = servletContext.getRealPath("/");
		File outputfile = new File(rootDirectory + "\\data\\doctor_" + id + ".png");
		BufferedImage bufferedImage = ImageIO.read(doctorPicture.getInputStream());
		if (bufferedImage != null) {
			ImageIO.write(bufferedImage, "PNG", outputfile);
		}
	}
	
	@RequestMapping(value = "/details")
	public String showDoctorDetails() {
		return "admin/doctor_details";
	}
}
