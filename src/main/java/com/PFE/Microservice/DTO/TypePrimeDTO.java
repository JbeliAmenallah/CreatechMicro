package com.PFE.Microservice.DTO;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class TypePrimeDTO {
    private String code;
    private String libele;
    private String cnss;
    private String impo;
    private Double montant;
    private String type;
}
