package com.rental.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import com.rental.entity.*;
import com.rental.exception.*;
import com.rental.service.*;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/guest")
public class GuestController {
 
	private GuestService  guestService;
	
	 
    private PasswordEncoder passwordEncoder;
	 
	@PostMapping("/registerGuest")
	public ResponseEntity<Guest> registerAsGuest(@Valid @RequestBody Guest guest) throws GuestException{
		guest.setPassword(passwordEncoder.encode(guest.getPassword()));
		Guest g=guestService.registerAsGuest(guest);
		return new ResponseEntity<Guest>(g,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/guest/{guest_id}")
	public ResponseEntity<Guest> getGuestById(@PathVariable("guest_id") Integer guest_id) throws GuestException{
		Guest g=guestService.getGuestById(guest_id);
		return new ResponseEntity<Guest>(g,HttpStatus.OK);
	}
	
	@PutMapping("/updateGuest")
	public ResponseEntity<Guest> updateGuest(@Valid @RequestBody Guest g) throws GuestException{
		g.setPassword(passwordEncoder.encode(g.getPassword()));
		Guest gst=guestService.updateGuest(g);
		return new ResponseEntity<Guest>(gst,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/guest/{guest_id}")
	public ResponseEntity<String> deleteGuestById(@PathVariable("guest_id") Integer guest_id) throws GuestException{
		 guestService.deleteGuest(guest_id);
		 return new ResponseEntity<String>("Guest deleted successfully.",HttpStatus.OK);
	}
}
