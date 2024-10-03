package com.braggaircharters.dao;

import java.util.List;

import com.braggaircharters.dao.GenericDAO;
import com.braggaircharters.domain.FlightCrew;





public interface FlightCrewDAO extends GenericDAO<FlightCrew, Integer> {
  
	List<FlightCrew> findAll();
	






}


