package com.braggaircharters.dao;

import java.util.List;

import com.braggaircharters.dao.GenericDAO;
import com.braggaircharters.domain.Airport;





public interface AirportDAO extends GenericDAO<Airport, Integer> {
  
	List<Airport> findAll();
	






}


