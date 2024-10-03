package com.braggaircharters.dao;

import java.util.List;

import com.braggaircharters.dao.GenericDAO;
import com.braggaircharters.domain.Booking;





public interface BookingDAO extends GenericDAO<Booking, Integer> {
  
	List<Booking> findAll();
	






}


