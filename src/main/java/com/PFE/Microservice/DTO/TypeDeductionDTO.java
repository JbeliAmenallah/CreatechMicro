package com.PFE.Microservice.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TypeDeductionDTO {

    private Long id;
    private String ref;
    private String designation;
    private String commune;
    private Double montant;
    private Double pourcentage;

    // Constructors, Getters, and Setters
}
