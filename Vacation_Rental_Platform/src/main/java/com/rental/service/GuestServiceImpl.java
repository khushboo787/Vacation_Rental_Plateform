package com.rental.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rental.entity.Guest;
import com.rental.exception.GuestException;
import com.rental.repository.GuestRepository;

@Service
public class GuestServiceImpl implements GuestService {

	    @Autowired
	    private GuestRepository guestRepository;

	    @Override
	    public Guest registerAsGuest(Guest guest) {
	        return guestRepository.save(guest);
	    }
	    
	    @Override
	    public Guest updateGuest( Guest guestDetails) throws GuestException {
	    	Optional<Guest> opt= guestRepository.findById(guestDetails.getGuestId());
			if(opt.isPresent()) {
				return guestRepository.save(guestDetails);
				
			}
			 
			throw new GuestException("No any Guest found with Id: "+ guestDetails.getGuestId());
	    }
	    

	    @Override
	    public List<Guest> getAllGuests() throws  GuestException{
	     return  guestRepository.findAll();    		  
	        
	    }

	    @Override
	    public Guest getGuestById(int guestId) throws GuestException {
	        return guestRepository.findById(guestId)
	                .orElseThrow(() -> new GuestException("Guest not found with id: " + guestId));
	    }

	    @Override
	    public void deleteGuest(int guestId) {
	         guestRepository.deleteById(guestId);
	         System.out.println("Guest deleted successfully.");
	    }

		 

		

}