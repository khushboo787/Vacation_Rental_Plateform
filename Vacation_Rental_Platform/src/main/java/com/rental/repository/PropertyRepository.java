package com.rental.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.rental.entity.Host;
import com.rental.entity.Property;

public interface PropertyRepository extends JpaRepository<Property, Integer> {

	public Optional<List<Property>> findByHost(Host host);
	
	public Optional<List<Property>> findByLocation(String location);
}

