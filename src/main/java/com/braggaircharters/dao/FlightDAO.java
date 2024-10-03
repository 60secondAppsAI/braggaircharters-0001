package com.braggaircharters.dao;

import java.util.List;

import com.braggaircharters.dao.GenericDAO;
import com.braggaircharters.domain.Flight;





public interface FlightDAO extends GenericDAO<Flight, Integer> {
  
	List<Flight> findAll();
	






}


