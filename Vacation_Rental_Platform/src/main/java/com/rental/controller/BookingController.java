package com.rental.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.rental.entity.*;
import com.rental.exception.*;
import com.rental.service.BookingService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@CrossOrigin(origins = "*")
public class BookingController {

	 
	private BookingService bookService;
	
	@PostMapping("/booking")
	public ResponseEntity<Booking> makeABooking(@RequestBody BookingDTO bkg) throws BookingException,GuestException,PropertyException{
		log.info("Inside a booking Controller.");
		Booking bk=bookService.makeABooking(bkg);
		return new ResponseEntity<Booking>(bk,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/booking/{bookingID}")
	public ResponseEntity<Booking> getBookingDetails(@PathVariable("bookingID") int bookingID) throws BookingException{
		Booking b=bookService.getBookingById(bookingID);
		return new ResponseEntity<>(b,HttpStatus.OK);
	}
	
	@DeleteMapping("/booking/{bkingID}")
	public ResponseEntity<Booking> cancelBookingById(@PathVariable("bkingID") int bkingID) throws BookingException{
		Booking b=bookService.cancelBookingById(bkingID);
		return new ResponseEntity<>(b,HttpStatus.OK);
	}
	
	@GetMapping("/bookingByProperty/{proId}")
	public ResponseEntity<List<Booking>> getAllBookingsOfAProperty(@PathVariable("proId") int proId) throws BookingException{
		List<Booking> li=bookService.getAllBookingsByProperty(proId);
		return new ResponseEntity<>(li,HttpStatus.OK);
	}
	
	@GetMapping("/bookingAll")
	public ResponseEntity<List<Booking>> getAllBookings() throws BookingException{
		List<Booking> li=bookService.getAllBookings();
		return new ResponseEntity<>(li,HttpStatus.OK);
	}
}
