package com.braggaircharters.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.braggaircharters.domain.Aircraft;
import com.braggaircharters.dto.AircraftDTO;
import com.braggaircharters.dto.AircraftSearchDTO;
import com.braggaircharters.dto.AircraftPageDTO;
import com.braggaircharters.dto.AircraftConvertCriteriaDTO;
import com.braggaircharters.service.GenericService;
import com.braggaircharters.dto.common.RequestDTO;
import com.braggaircharters.dto.common.ResultDTO;
import java.util.List;
import java.util.Optional;





public interface AircraftService extends GenericService<Aircraft, Integer> {

	List<Aircraft> findAll();

	ResultDTO addAircraft(AircraftDTO aircraftDTO, RequestDTO requestDTO);

	ResultDTO updateAircraft(AircraftDTO aircraftDTO, RequestDTO requestDTO);

    Page<Aircraft> getAllAircrafts(Pageable pageable);

    Page<Aircraft> getAllAircrafts(Specification<Aircraft> spec, Pageable pageable);

	ResponseEntity<AircraftPageDTO> getAircrafts(AircraftSearchDTO aircraftSearchDTO);
	
	List<AircraftDTO> convertAircraftsToAircraftDTOs(List<Aircraft> aircrafts, AircraftConvertCriteriaDTO convertCriteria);

	AircraftDTO getAircraftDTOById(Integer aircraftId);







}





