package com.rental.entity;

import java.time.LocalDate;
import java.util.Date;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotNull
    @ManyToOne
    @JoinColumn(name = "property_id")
    private Property property;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "guest_id")
    private Guest guest;

    @NotNull
    private LocalDate checkInDate;

    @NotNull
    private LocalDate checkOutDate;

    
     
}