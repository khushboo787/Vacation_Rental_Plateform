package com.rental.service;

import java.util.List;

import com.rental.entity.Host;
import com.rental.exception.HostException;
import com.rental.exception.PropertyException;

public interface HostService {
    Host createHost(Host host);
    
    Host updateHost(int hostId, Host hostDetails) throws HostException;
    
    List<Host> getAllHosts() throws HostException;
    
    Host getHostById(int hostId) throws HostException;
    
    Host deleteHost(int hostId) throws HostException;

	Host addHostWithProperty(Host ho, int propertyID) throws HostException, PropertyException;
}
