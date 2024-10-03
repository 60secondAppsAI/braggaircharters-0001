package com.braggaircharters.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.braggaircharters.domain.Booking;
import com.braggaircharters.dto.BookingDTO;
import com.braggaircharters.dto.BookingSearchDTO;
import com.braggaircharters.dto.BookingPageDTO;
import com.braggaircharters.dto.BookingConvertCriteriaDTO;
import com.braggaircharters.service.GenericService;
import com.braggaircharters.dto.common.RequestDTO;
import com.braggaircharters.dto.common.ResultDTO;
import java.util.List;
import java.util.Optional;





public interface BookingService extends GenericService<Booking, Integer> {

	List<Booking> findAll();

	ResultDTO addBooking(BookingDTO bookingDTO, RequestDTO requestDTO);

	ResultDTO updateBooking(BookingDTO bookingDTO, RequestDTO requestDTO);

    Page<Booking> getAllBookings(Pageable pageable);

    Page<Booking> getAllBookings(Specification<Booking> spec, Pageable pageable);

	ResponseEntity<BookingPageDTO> getBookings(BookingSearchDTO bookingSearchDTO);
	
	List<BookingDTO> convertBookingsToBookingDTOs(List<Booking> bookings, BookingConvertCriteriaDTO convertCriteria);

	BookingDTO getBookingDTOById(Integer bookingId);







}





