package com.braggaircharters.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.braggaircharters.domain.Flight;
import com.braggaircharters.dto.FlightDTO;
import com.braggaircharters.dto.FlightSearchDTO;
import com.braggaircharters.dto.FlightPageDTO;
import com.braggaircharters.dto.FlightConvertCriteriaDTO;
import com.braggaircharters.service.GenericService;
import com.braggaircharters.dto.common.RequestDTO;
import com.braggaircharters.dto.common.ResultDTO;
import java.util.List;
import java.util.Optional;





public interface FlightService extends GenericService<Flight, Integer> {

	List<Flight> findAll();

	ResultDTO addFlight(FlightDTO flightDTO, RequestDTO requestDTO);

	ResultDTO updateFlight(FlightDTO flightDTO, RequestDTO requestDTO);

    Page<Flight> getAllFlights(Pageable pageable);

    Page<Flight> getAllFlights(Specification<Flight> spec, Pageable pageable);

	ResponseEntity<FlightPageDTO> getFlights(FlightSearchDTO flightSearchDTO);
	
	List<FlightDTO> convertFlightsToFlightDTOs(List<Flight> flights, FlightConvertCriteriaDTO convertCriteria);

	FlightDTO getFlightDTOById(Integer flightId);







}





