package com.rental.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rental.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
	
	//@Query("select bookings from Property where propertyId=?1")
	//public List<Booking> getAllBookingsBypropertyId(int propertyId);
	
//	List<Booking> findByGuestId(int guestId);

	//public List<Booking> findByPropertyId(int propertyId);
 

	 
}
