package com.rental.service;

import java.util.List;

import com.rental.entity.Property;
import com.rental.entity.PropertyDTO;
import com.rental.entity.PropertyDTO2;
import com.rental.exception.HostException;
import com.rental.exception.PropertyException;

public interface PropertyService {
	
	Property addPropertyWithHost(PropertyDTO prt) throws PropertyException;

	Property addPropertyWithoutHost(PropertyDTO2 prt) throws PropertyException;

	List<Property> getAllPropetyByHostId(int hostId) throws HostException;

	List<Property> searchPropertyByLocation(String location) throws PropertyException;

	Property getPropertyById(Integer propertyID) throws PropertyException;

	List<Property> getAllProperties() throws PropertyException;

	List<Property> getSortedPropertyListWithField(String field, String direction);
	
	Property deleteProperty(Integer id) throws PropertyException;
    
}
