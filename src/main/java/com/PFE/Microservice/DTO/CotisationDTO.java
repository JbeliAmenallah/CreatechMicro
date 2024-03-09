package com.PFE.Microservice.DTO;

import lombok.Data;

import jakarta.validation.constraints.NotNull;

@Data
public class CotisationDTO {

    private Long id;

    @NotNull(message = "Libele is required")
    private String libele;

    @NotNull(message = "Taux is required")
    private double taux;

    @NotNull(message = "Annee is required")
    private int annee;

    @NotNull(message = "Contact name is required")
    private String contactName;

    // Getters and Setters
}
