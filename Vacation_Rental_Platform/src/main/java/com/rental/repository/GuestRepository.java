package com.rental.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.rental.entity.Guest;

public interface GuestRepository extends JpaRepository<Guest, Integer> {

	Optional<Guest> findByEmail(String username);
}