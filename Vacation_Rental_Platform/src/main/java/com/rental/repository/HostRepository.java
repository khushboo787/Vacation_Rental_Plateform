package com.rental.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.rental.entity.Host;

public interface HostRepository extends JpaRepository<Host, Integer> {
}
