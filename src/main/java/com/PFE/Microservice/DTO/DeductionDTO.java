package com.PFE.Microservice.DTO;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DeductionDTO {
    private Long id;
    private Integer annee;
    private Double salaire;
    private Double montant;
    private Integer nombre;
    private String ref; // Only include the ref attribute for TypeDeduction
    private Long contactId; // New field for contactId

}
