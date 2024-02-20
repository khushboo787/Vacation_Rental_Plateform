package com.rental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.rental.entity.Guest;
import com.rental.repository.GuestRepository;

@RestController
@CrossOrigin(origins = "*")
public class LoginController {

	@Autowired
	private GuestRepository repo;
	
	@GetMapping("/signIn")
	public ResponseEntity<Guest> getLoggedInCustomerDetailsHandler(Authentication auth){
		
		
		Guest g= repo.findByEmail(auth.getName()).orElseThrow(() -> new BadCredentialsException("Invalid Username or password"));
		
	 	 
		 return new ResponseEntity<>(g, HttpStatus.ACCEPTED);
		
	}
	
}
