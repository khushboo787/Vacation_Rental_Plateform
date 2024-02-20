package com.rental.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.rental.entity.*;
import com.rental.exception.*;
import com.rental.repository.*;

@Service
public class BookingServiceImpl implements BookingService {
	 
	private BookingRepository bookingRepository;
	
	  
	private GuestRepository guestRepo;
	
	 
	private PropertyRepository proRepo;
	
	@Override
	public Booking makeABooking(BookingDTO b) throws BookingException,GuestException,PropertyException {
		Optional<Guest> opt=guestRepo.findById(b.getGuestId());
		if(opt.isEmpty()) {
			throw new GuestException("There are no guest by ID: "+b.getGuestId());
		}
		Guest g=opt.get();
		Optional<Property> opt2=proRepo.findById(b.getPropertyId());
		if(opt2.isEmpty()) {
			throw new PropertyException("There are no properties by id: "+b.getPropertyId());
		}
		Property p=opt2.get();
		Booking bk=new Booking();
		bk.setCheckInDate(b.getCheckInDate());
		bk.setCheckOutDate(b.getCheckOutDate());
		bk.setProperty(p);
		bk.setGuest(g);
		
		return bookingRepository.save(bk);
	}


	@Override
	public Booking cancelBookingById(int bID) throws BookingException {
		Optional<Booking> opt=bookingRepository.findById(bID);
		if(opt.isPresent()) {
			Booking b=opt.get();
			bookingRepository.delete(b);
			return b;
		}
		throw new BookingException("No any booking with ID: "+bID);
	}

	@Override
	public List<Booking> getAllBookings() throws BookingException {
		List<Booking> li=bookingRepository.findAll();
		if(li.size()==0) {
			throw new BookingException("There are no bookings");
		}
		return li;
	}

	@Override
	public List<Booking> getAllBookingsByProperty(int propertyId) throws BookingException {
//		List<Booking> list=bookingRepository.getAllBookingsBypropertyId(propertyId);
//		if(list.size()==0) {
//			throw new BookingException("No any bookings for this property");
//		}
//		return list;
		return null;
	}
	

	@Override
    public Booking getBookingById(int bookingId) throws BookingException {
		Optional<Booking> opt=bookingRepository.findById(bookingId);
		if(opt.isPresent()) {
			return opt.get();
		}
		throw new BookingException("Booking not found with ID: " + bookingId);
    }

	

	

	@Override
    public List<Booking> getBookingsByProperty(int propertyId) {
      //  return bookingRepository.findByPropertyId(propertyId);
		return null;
    }


	@Override
	public List<Booking> getBookingsByGuest(int guestId) {
		// TODO Auto-generated method stub
		return null;
	}


	 
}
