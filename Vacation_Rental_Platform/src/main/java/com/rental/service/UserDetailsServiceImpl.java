package com.rental.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.rental.entity.Guest;
import com.rental.repository.GuestRepository;

@Service
public class  UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private GuestRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		
		Optional<Guest> opt= repo.findByEmail(username);

		if(opt.isPresent()) {
			
			Guest g= opt.get();
			
			List<GrantedAuthority> authorities= new ArrayList<>();
			 
			return new User(g.getEmail(), g.getPassword(), authorities);
			
		}else
			throw new BadCredentialsException("User Details not found with this username: "+username);
		
		
	}

}

