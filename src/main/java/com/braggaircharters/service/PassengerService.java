package com.braggaircharters.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.braggaircharters.domain.Passenger;
import com.braggaircharters.dto.PassengerDTO;
import com.braggaircharters.dto.PassengerSearchDTO;
import com.braggaircharters.dto.PassengerPageDTO;
import com.braggaircharters.dto.PassengerConvertCriteriaDTO;
import com.braggaircharters.service.GenericService;
import com.braggaircharters.dto.common.RequestDTO;
import com.braggaircharters.dto.common.ResultDTO;
import java.util.List;
import java.util.Optional;





public interface PassengerService extends GenericService<Passenger, Integer> {

	List<Passenger> findAll();

	ResultDTO addPassenger(PassengerDTO passengerDTO, RequestDTO requestDTO);

	ResultDTO updatePassenger(PassengerDTO passengerDTO, RequestDTO requestDTO);

    Page<Passenger> getAllPassengers(Pageable pageable);

    Page<Passenger> getAllPassengers(Specification<Passenger> spec, Pageable pageable);

	ResponseEntity<PassengerPageDTO> getPassengers(PassengerSearchDTO passengerSearchDTO);
	
	List<PassengerDTO> convertPassengersToPassengerDTOs(List<Passenger> passengers, PassengerConvertCriteriaDTO convertCriteria);

	PassengerDTO getPassengerDTOById(Integer passengerId);







}





