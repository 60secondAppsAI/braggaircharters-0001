package com.braggaircharters.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.braggaircharters.domain.Crew;
import com.braggaircharters.dto.CrewDTO;
import com.braggaircharters.dto.CrewSearchDTO;
import com.braggaircharters.dto.CrewPageDTO;
import com.braggaircharters.dto.CrewConvertCriteriaDTO;
import com.braggaircharters.service.GenericService;
import com.braggaircharters.dto.common.RequestDTO;
import com.braggaircharters.dto.common.ResultDTO;
import java.util.List;
import java.util.Optional;





public interface CrewService extends GenericService<Crew, Integer> {

	List<Crew> findAll();

	ResultDTO addCrew(CrewDTO crewDTO, RequestDTO requestDTO);

	ResultDTO updateCrew(CrewDTO crewDTO, RequestDTO requestDTO);

    Page<Crew> getAllCrews(Pageable pageable);

    Page<Crew> getAllCrews(Specification<Crew> spec, Pageable pageable);

	ResponseEntity<CrewPageDTO> getCrews(CrewSearchDTO crewSearchDTO);
	
	List<CrewDTO> convertCrewsToCrewDTOs(List<Crew> crews, CrewConvertCriteriaDTO convertCriteria);

	CrewDTO getCrewDTOById(Integer crewId);







}





