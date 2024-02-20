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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rental.entity.*;
import com.rental.exception.*;
import com.rental.service.HostService;
 
import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
public class HostController {

	 
	private HostService hostService;
	
	@GetMapping("/hostHello")
	public ResponseEntity<String> pringHello(){
		 
		return new ResponseEntity<String>("Hello   okkkkkkkkk",HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/host")
	public ResponseEntity<Host> addHost(@Valid @RequestBody Host ho) throws HostException{
		Host h=hostService.createHost(ho);
		return new ResponseEntity<Host>(h,HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/hostWithProperty")
	public ResponseEntity<Host> addLandLord(@Valid @RequestBody Host ho,@RequestParam Integer propertyID) throws HostException, PropertyException{
		Host h=hostService.addHostWithProperty(ho, propertyID);
		return new ResponseEntity<Host>(h,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/host/{hostId}")
	public ResponseEntity<Host> getHostByID(@PathVariable("hostId") Integer hostId) throws HostException{
		Host h=hostService.getHostById(hostId);
		return new ResponseEntity<Host>(h,HttpStatus.OK);
	}
	
	@GetMapping("/allHosts")
	public ResponseEntity<List<Host>> getAllHost() throws HostException{
		List<Host> li=hostService.getAllHosts();
		return new ResponseEntity<List<Host>>(li,HttpStatus.OK);
	}
	
	@DeleteMapping("/host/{hostId}")
	public ResponseEntity<Host> deleteHostByID(@PathVariable("hostId") Integer  hostId) throws HostException{
		Host h=hostService.deleteHost(hostId);
		return new ResponseEntity<Host>(h,HttpStatus.OK);
	}
}
