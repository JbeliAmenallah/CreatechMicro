package com.PFE.Microservice.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Deduction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int annee;
    private double salaire;
    private double montant;
    private int nombre;

    @ManyToOne
    @JoinColumn(name = "type_deduction_id")
    private TypeDeduction typeDeduction;
    @ManyToOne
    @JoinColumn(name = "contact_id")
    private Contact contact;
    // Constructors, getters, setters
}
