package com.braggaircharters.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.braggaircharters.domain.Baggage;
import com.braggaircharters.dto.BaggageDTO;
import com.braggaircharters.dto.BaggageSearchDTO;
import com.braggaircharters.dto.BaggagePageDTO;
import com.braggaircharters.dto.BaggageConvertCriteriaDTO;
import com.braggaircharters.service.GenericService;
import com.braggaircharters.dto.common.RequestDTO;
import com.braggaircharters.dto.common.ResultDTO;
import java.util.List;
import java.util.Optional;





public interface BaggageService extends GenericService<Baggage, Integer> {

	List<Baggage> findAll();

	ResultDTO addBaggage(BaggageDTO baggageDTO, RequestDTO requestDTO);

	ResultDTO updateBaggage(BaggageDTO baggageDTO, RequestDTO requestDTO);

    Page<Baggage> getAllBaggages(Pageable pageable);

    Page<Baggage> getAllBaggages(Specification<Baggage> spec, Pageable pageable);

	ResponseEntity<BaggagePageDTO> getBaggages(BaggageSearchDTO baggageSearchDTO);
	
	List<BaggageDTO> convertBaggagesToBaggageDTOs(List<Baggage> baggages, BaggageConvertCriteriaDTO convertCriteria);

	BaggageDTO getBaggageDTOById(Integer baggageId);







}





