package com.rental.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rental.entity.Host;
import com.rental.entity.Property;
import com.rental.exception.HostException;
import com.rental.exception.PropertyException;
import com.rental.repository.HostRepository;
import com.rental.repository.PropertyRepository;

@Service
public class HostServiceImpl implements HostService {
	    @Autowired
	    private HostRepository hostRepository;

	    @Autowired
	    private PropertyRepository repo;

	   
	@Override
	public Host createHost(Host host) {
		return hostRepository.save(host);
	}

	@Override
	public Host updateHost(int hostId, Host hostDetails) throws HostException {
		    Host host = getHostById(hostId);
	        host.setName(hostDetails.getName());
	        host.setActive(hostDetails.isActive());
	        host.setLocation(hostDetails.getLocation());
	        host.setPropertyType(hostDetails.getPropertyType());
	        host.setAbout(hostDetails.getAbout());
	        host.setHostingSince(hostDetails.getHostingSince());
	        return hostRepository.save(host);
	}

	@Override
	public List<Host> getAllHosts() throws HostException {
		List<Host> list=hostRepository.findAll();
		if(list.size()==0) {
			throw new  HostException("No any hosts are available now.");
		}
		return list;
	}
    
	@Override
	public Host addHostWithProperty(Host ho, int propertyID)
			throws HostException, PropertyException {
		Optional<Property> opt=repo.findById(propertyID);
		if(opt.isEmpty()) {
			throw new PropertyException("There are no property by id: "+propertyID);
		}
		Property pro=opt.get();
		ho.getProperties().add(pro);
		return hostRepository.save(ho);
	}
	
	@Override
	public Host getHostById(int hostId) throws HostException {
		Optional<Host> opt=hostRepository.findById(hostId);
		if(opt.isPresent()) {
			return opt.get();
		}
		throw new HostException("Host with id: "+ hostId +" not found");
	}

	@Override
	public Host deleteHost(int hostId) throws HostException {
		Optional<Host> opt=hostRepository.findById(hostId);
		if(opt.isPresent()) {
			Host host=opt.get();
			hostRepository.delete(host);
			return host;
		}
		throw new HostException("Host with id: "+ hostId +" not found");
		
	}

}

