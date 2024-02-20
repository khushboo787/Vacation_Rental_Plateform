package com.rental.entity;

import java.util.ArrayList;
import java.util.List;


import com.rental.entity.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;


@Entity
@Setter
@Getter
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int propertyId;

	private String location;
	private Integer price;
	@Enumerated(EnumType.STRING)
	private PropertyType propertyType;
	@ManyToOne
	private Host host;
	@OneToMany(mappedBy = "property")
	private List<Booking> bookings=new ArrayList<>();
	 
    
     
}