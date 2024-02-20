package com.rental.entity;

import java.time.LocalDate;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingDTO {

    	private int id;
	    private int propertyId;
	    private int guestId;
	    private LocalDate checkInDate;
	    private LocalDate checkOutDate;
}
