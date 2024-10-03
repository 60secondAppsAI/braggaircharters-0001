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

import com.braggaircharters.domain.Passenger;
import com.braggaircharters.dto.PassengerDTO;
import com.braggaircharters.dto.PassengerSearchDTO;
import com.braggaircharters.dto.PassengerPageDTO;
import com.braggaircharters.service.PassengerService;
import com.braggaircharters.dto.common.RequestDTO;
import com.braggaircharters.dto.common.ResultDTO;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;




@CrossOrigin(origins = "*")
@RequestMapping("/passenger")
@RestController
public class PassengerController {

	private final static Logger logger = LoggerFactory.getLogger(PassengerController.class);

	@Autowired
	PassengerService passengerService;



	//@AllowSystem(AuthScopes.READ)
	@RequestMapping(value="/", method = RequestMethod.GET)
	public List<Passenger> getAll() {

		List<Passenger> passengers = passengerService.findAll();
		
		return passengers;	
	}

	//@ReadAccess
	@GetMapping(value = "/{passengerId}")
	@ResponseBody
	public PassengerDTO getPassenger(@PathVariable Integer passengerId) {
		
		return (passengerService.getPassengerDTOById(passengerId));
	}

 	//@WriteAccess
 	@RequestMapping(value = "/addPassenger", method = RequestMethod.POST)
	public ResponseEntity<?> addPassenger(@RequestBody PassengerDTO passengerDTO, HttpServletRequest request) {
		RequestDTO requestDTO = new RequestDTO(request);
		ResultDTO result = passengerService.addPassenger(passengerDTO, requestDTO);
		
//		if (result.isSuccessful()) {
//		}
		
		return result.asResponseEntity();
	}

	//@ReadAccess
	@GetMapping("/passengers")
	public ResponseEntity<PassengerPageDTO> getPassengers(PassengerSearchDTO passengerSearchDTO) {
 
		return passengerService.getPassengers(passengerSearchDTO);
	}	

 	//@WriteAccess
	@RequestMapping(value = "/updatePassenger", method = RequestMethod.POST)
	public ResponseEntity<?> updatePassenger(@RequestBody PassengerDTO passengerDTO, HttpServletRequest request) {
		RequestDTO requestDTO = new RequestDTO(request);
		ResultDTO result = passengerService.updatePassenger(passengerDTO, requestDTO);
		
//		if (result.isSuccessful()) {
//		}

		return result.asResponseEntity();
	}



}
