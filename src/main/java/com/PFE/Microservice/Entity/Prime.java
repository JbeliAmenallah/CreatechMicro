package com.PFE.Microservice.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "prime")
public class Prime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "type_prime_id")
    private TypePrime typePrime;

    @ManyToOne
    @JoinColumn(name = "contact_id")
    private Contact contact;

    private Integer year;
    private String month;
    private Double montant;
    private String motif;

    // Constructors, Getters, and Setters
}
