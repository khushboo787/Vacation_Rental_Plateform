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
import com.rental.service.PropertyService;


@RestController
@CrossOrigin(origins = "*")
public class PropertyController {

	 
	private PropertyService proser;
	
	@PostMapping("/propertyWithoutlandlord")
	public ResponseEntity<Property> addPropertyWithoutHost(@RequestBody PropertyDTO2 prt) throws PropertyException{
		Property p=proser.addPropertyWithoutHost(prt);
		return new ResponseEntity<Property>(p,HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/property")
	public ResponseEntity<Property> addPropertyWithHost(@RequestBody PropertyDTO prt) throws PropertyException{
		Property p=proser.addPropertyWithHost(prt);
				return new ResponseEntity<Property>(p,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/propertyByHostID/{hostId}")
	public ResponseEntity<List<Property>> getAllPropetyOfAHost(@PathVariable("hostId") Integer hostId) throws HostException{
		List<Property> li=proser.getAllPropetyByHostId(hostId);
		return new ResponseEntity<List<Property>>(li,HttpStatus.OK);
	}
	
	@GetMapping("/propertyByLocation/{location}")
	public ResponseEntity<List<Property>> searchPropertyBasedOnLocation(@PathVariable("location") String location) throws PropertyException{
		List<Property> li=proser.searchPropertyByLocation(location);
		return new ResponseEntity<List<Property>>(li,HttpStatus.OK);
	}
	
	@GetMapping("/propertyByPropertyID/{propertyID}")
	public ResponseEntity<Property> getPropertyById(@PathVariable("propertyID") Integer propertyID) throws PropertyException{
		Property p=proser.getPropertyById(propertyID);
		return new ResponseEntity<Property>(p,HttpStatus.OK);
	}
	
	@GetMapping("/propertyAll")
	public ResponseEntity<List<Property>> getAllProperties() throws PropertyException{
		List<Property> li=proser.getAllProperties();
		return new ResponseEntity<List<Property>>(li,HttpStatus.OK);
	}
	
	@GetMapping("/getSortedProperties/{field}")
	public ResponseEntity<List<Property>> getSortedPropertyListWithField(@PathVariable("field") String field, @RequestParam("direction") String direction){
		List<Property> li= proser.getSortedPropertyListWithField(field, direction);
		return new ResponseEntity<List<Property>>(li,HttpStatus.OK);
	}
	
	 
	@DeleteMapping("/propertyByPropertyID/{propertyID}")
	public ResponseEntity<Property> deletePropertyById(@PathVariable("propertyID") Integer propertyID) throws PropertyException{
		Property p=proser.deleteProperty(propertyID);
		return new ResponseEntity<Property>(p,HttpStatus.OK);
	}
}
