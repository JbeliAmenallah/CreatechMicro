package com.PFE.Microservice.DTO;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PrimeDTO {
    private Long typePrimeId;
    private Long contactId;
    private Integer year;
    private String month;
    private Double montant;
    private String motif;
}
