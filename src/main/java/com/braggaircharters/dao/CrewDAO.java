package com.braggaircharters.dao;

import java.util.List;

import com.braggaircharters.dao.GenericDAO;
import com.braggaircharters.domain.Crew;





public interface CrewDAO extends GenericDAO<Crew, Integer> {
  
	List<Crew> findAll();
	






}


