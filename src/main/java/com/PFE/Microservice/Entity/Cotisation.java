package com.PFE.Microservice.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "cotisation")
public class Cotisation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String libele;

    private double taux;

    private int annee;

    @ManyToOne
    @JoinColumn(name = "contact_id")
    private Contact contact;

    // Constructors, Getters, and Setters
}
