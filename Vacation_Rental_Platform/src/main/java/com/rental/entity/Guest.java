package com.rental.entity;

import java.time.LocalDate;
import java.util.List;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Entity
@Data
@Setter
@Getter
public class Guest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int guestId;
    
    @NotBlank
    private String name;
    @Column(unique = true)
    
    @Email(message = "Please enter correct email address")
    private String email;
    
    @Size(min = 8, message = "password should have at least 8 characters")
    private String password;
    
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Past
    private LocalDate dateOfBirth;

    @Size(max = 1000)
    private String bio;

    @OneToMany(mappedBy = "guest", cascade = CascadeType.ALL)
    private List<Booking> bookings;

	 
    
     
}
