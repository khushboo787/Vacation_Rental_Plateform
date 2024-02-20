package com.rental.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import com.rental.entity.*;
import com.rental.entity.Property;
import com.rental.exception.*;
import com.rental.repository.*;

@Service
public class PropertyServiceImpl implements PropertyService {

	
		@Autowired
		private PropertyRepository proRepository;
		
		@Autowired
		private HostRepository hostRepository;

		@Override
		public Property addPropertyWithoutHost(PropertyDTO2 prt) throws PropertyException {
			Property p=new Property();
			p.setLocation(prt.getLocation());
			p.setPrice(prt.getPrice());
			p.setPropertyType(prt.getPropertyType());
			return proRepository.save(p);
		}

		@Override
		public Property addPropertyWithHost(PropertyDTO prt) throws PropertyException {
			Optional<Host> opt=hostRepository.findById(prt.getHostId());
			if(opt.isEmpty()) {
				throw new PropertyException("No any Host available with ID: "+ prt.getHostId());
			}
			Host ho=opt.get();
			Property p=new Property();
			p.setHost(ho);
			p.setLocation(prt.getLocation());
			p.setPrice(prt.getPrice());
			p.setPropertyType(prt.getPropertyType());
			return proRepository.save(p);
		}

		@Override
		public List<Property> getAllPropetyByHostId(int hostId) throws HostException {
			Optional<Host> opt=hostRepository.findById(hostId);
			if(opt.isEmpty()) {
				throw new HostException("No any host with ID: "+ hostId);
			}
			Host ho=opt.get();
			Optional<List<Property>> opt2=proRepository.findByHost(ho);
			if(opt2.isPresent()) {
				return opt2.get();
			}
			throw new HostException("There are no Properties owned by Host: "+ho.getName());
		}

		@Override
		public List<Property> searchPropertyByLocation(String location) throws PropertyException {
			Optional<List<Property>> opt2=proRepository.findByLocation(location);
			if(opt2.isPresent()) {
				List<Property> li=opt2.get();
				if(li.size()==0) {
					throw new PropertyException("There are no Properties for the given location: "+location);
				}
				return opt2.get();
			}
			throw new PropertyException("There are no any Properties for the given location: "+location);
		}
		

	 
		@Override
		public Property getPropertyById(Integer propertyID) throws PropertyException {
			Optional<Property> opt=proRepository.findById(propertyID);
			if(opt.isPresent()) {
				return opt.get();
			}
			throw new PropertyException("No any property exists with property ID: "+propertyID);
		}

		@Override
		public List<Property> getAllProperties() throws PropertyException {
			List<Property> list=proRepository.findAll();
			if(list.size()==0) {
				throw new PropertyException("There are no any properties");
			}
			return list;
		}

		@Override
		public List<Property> getSortedPropertyListWithField(String field, String direction) {
			return proRepository.findAll(direction.equals("asc")? Sort.by(field).ascending() : Sort.by(field).descending());
		}

		@Override
		public Property deleteProperty(Integer id) throws PropertyException {
			Optional<Property> opt=proRepository.findById(id);
			if(opt.isPresent()) {
				Property p=opt.get();
				proRepository.delete(p);
				return p;
			}
			throw new PropertyException("No any property exists with property ID: "+ id);
		}


}