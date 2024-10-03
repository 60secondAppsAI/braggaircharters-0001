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

import com.braggaircharters.domain.Baggage;
import com.braggaircharters.dto.BaggageDTO;
import com.braggaircharters.dto.BaggageSearchDTO;
import com.braggaircharters.dto.BaggagePageDTO;
import com.braggaircharters.service.BaggageService;
import com.braggaircharters.dto.common.RequestDTO;
import com.braggaircharters.dto.common.ResultDTO;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;




@CrossOrigin(origins = "*")
@RequestMapping("/baggage")
@RestController
public class BaggageController {

	private final static Logger logger = LoggerFactory.getLogger(BaggageController.class);

	@Autowired
	BaggageService baggageService;



	//@AllowSystem(AuthScopes.READ)
	@RequestMapping(value="/", method = RequestMethod.GET)
	public List<Baggage> getAll() {

		List<Baggage> baggages = baggageService.findAll();
		
		return baggages;	
	}

	//@ReadAccess
	@GetMapping(value = "/{baggageId}")
	@ResponseBody
	public BaggageDTO getBaggage(@PathVariable Integer baggageId) {
		
		return (baggageService.getBaggageDTOById(baggageId));
	}

 	//@WriteAccess
 	@RequestMapping(value = "/addBaggage", method = RequestMethod.POST)
	public ResponseEntity<?> addBaggage(@RequestBody BaggageDTO baggageDTO, HttpServletRequest request) {
		RequestDTO requestDTO = new RequestDTO(request);
		ResultDTO result = baggageService.addBaggage(baggageDTO, requestDTO);
		
//		if (result.isSuccessful()) {
//		}
		
		return result.asResponseEntity();
	}

	//@ReadAccess
	@GetMapping("/baggages")
	public ResponseEntity<BaggagePageDTO> getBaggages(BaggageSearchDTO baggageSearchDTO) {
 
		return baggageService.getBaggages(baggageSearchDTO);
	}	

 	//@WriteAccess
	@RequestMapping(value = "/updateBaggage", method = RequestMethod.POST)
	public ResponseEntity<?> updateBaggage(@RequestBody BaggageDTO baggageDTO, HttpServletRequest request) {
		RequestDTO requestDTO = new RequestDTO(request);
		ResultDTO result = baggageService.updateBaggage(baggageDTO, requestDTO);
		
//		if (result.isSuccessful()) {
//		}

		return result.asResponseEntity();
	}



}
