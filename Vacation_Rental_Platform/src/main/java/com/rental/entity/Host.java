package com.rental.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;


@Entity
@Data
public class Host {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotBlank
    private String name;

    private boolean active;

    @NotBlank
    private String location;

    @Enumerated(EnumType.STRING)
    private PropertyType propertyType;

    @NotBlank
    @Size(max = 1000)
    private String about;

    @Past
    private LocalDate hostingSince;

    @OneToMany(mappedBy = "host", cascade = CascadeType.ALL)
    private List<Property> properties;
    
    
}
