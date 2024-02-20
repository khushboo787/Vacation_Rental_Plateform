package com.rental.service;

import java.util.List;

import com.rental.entity.Guest;
import com.rental.exception.GuestException;

public interface GuestService {
    
    List<Guest> getAllGuests() throws GuestException;
   
    void  deleteGuest(int guestId);

	Guest getGuestById(int guestId) throws GuestException;


	Guest registerAsGuest(Guest guest);


	Guest updateGuest(Guest guestDetails) throws GuestException;
}
