package com.saigonese.fms.controller;

import com.saigonese.fms.domain.Booking;
import com.saigonese.fms.service.BookingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * 
 * @author Quang Hiep Nguyen
 *
 */

@Controller
public class BookingController {

	@Autowired
	private BookingService bookingService;
	
	@RequestMapping(value = "/mybooking", method = RequestMethod.GET)
	public String getMyBooking() {		
		return "booking/myBooking";
	}
	
	@RequestMapping(value = "/mybooking", method = RequestMethod.POST)
	public String getBooking(@RequestParam("cCode") String cCode, RedirectAttributes rAttributes) {
		Booking booking = bookingService.findBookingByCC(cCode);
		if(booking != null) {
			rAttributes.addFlashAttribute(booking);
			return "redirect:/booking/detail";
		}else {
			rAttributes.addFlashAttribute("cCode", cCode);			
			return "redirect:/mybooking";
		}
		
	}
	
	@RequestMapping(value = "/booking/detail", method = RequestMethod.GET)
	public String bookingDetail() {		
		return "booking/detail";
	}

}
