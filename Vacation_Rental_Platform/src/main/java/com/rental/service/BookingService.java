package com.rental.service;

import java.util.List;
import com.rental.entity.Booking;
import com.rental.entity.BookingDTO;
import com.rental.exception.BookingException;
import com.rental.exception.GuestException;
import com.rental.exception.PropertyException;

public interface BookingService {
   
	Booking makeABooking(BookingDTO b) throws BookingException, GuestException, PropertyException;
	
    List<Booking> getAllBookings() throws BookingException;
    
    Booking getBookingById(int bookingId) throws BookingException;
    
    List<Booking> getBookingsByProperty(int propertyId);
    
    List<Booking> getBookingsByGuest(int guestId);

	List<Booking> getAllBookingsByProperty(int propertyId) throws BookingException;

	Booking cancelBookingById(int bID) throws BookingException;

	
}
