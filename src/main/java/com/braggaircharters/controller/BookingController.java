package com.braggaircharters.controller;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.List;
import java.util.ArrayList;


import com.braggaircharters.util.Util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.sql.Timestamp;
import java.util.Date;

import com.braggaircharters.domain.Booking;
import com.braggaircharters.dto.BookingDTO;
import com.braggaircharters.dto.BookingSearchDTO;
import com.braggaircharters.dto.BookingPageDTO;
import com.braggaircharters.service.BookingService;
import com.braggaircharters.dto.common.RequestDTO;
import com.braggaircharters.dto.common.ResultDTO;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;




@CrossOrigin(origins = "*")
@RequestMapping("/booking")
@RestController
public class BookingController {

	private final static Logger logger = LoggerFactory.getLogger(BookingController.class);

	@Autowired
	BookingService bookingService;



	//@AllowSystem(AuthScopes.READ)
	@RequestMapping(value="/", method = RequestMethod.GET)
	public List<Booking> getAll() {

		List<Booking> bookings = bookingService.findAll();
		
		return bookings;	
	}

	//@ReadAccess
	@GetMapping(value = "/{bookingId}")
	@ResponseBody
	public BookingDTO getBooking(@PathVariable Integer bookingId) {
		
		return (bookingService.getBookingDTOById(bookingId));
	}

 	//@WriteAccess
 	@RequestMapping(value = "/addBooking", method = RequestMethod.POST)
	public ResponseEntity<?> addBooking(@RequestBody BookingDTO bookingDTO, HttpServletRequest request) {
		RequestDTO requestDTO = new RequestDTO(request);
		ResultDTO result = bookingService.addBooking(bookingDTO, requestDTO);
		
//		if (result.isSuccessful()) {
//		}
		
		return result.asResponseEntity();
	}

	//@ReadAccess
	@GetMapping("/bookings")
	public ResponseEntity<BookingPageDTO> getBookings(BookingSearchDTO bookingSearchDTO) {
 
		return bookingService.getBookings(bookingSearchDTO);
	}	

 	//@WriteAccess
	@RequestMapping(value = "/updateBooking", method = RequestMethod.POST)
	public ResponseEntity<?> updateBooking(@RequestBody BookingDTO bookingDTO, HttpServletRequest request) {
		RequestDTO requestDTO = new RequestDTO(request);
		ResultDTO result = bookingService.updateBooking(bookingDTO, requestDTO);
		
//		if (result.isSuccessful()) {
//		}

		return result.asResponseEntity();
	}



}
