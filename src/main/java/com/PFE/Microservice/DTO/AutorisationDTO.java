package com.PFE.Microservice.DTO;

import lombok.*;

import jakarta.validation.constraints.NotNull;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AutorisationDTO {

    private Long id;

    @NotNull(message = "Date is required")
    private Date date;

    @NotNull(message = "Contact name is required")
    private String contactName;

    // Getters and Setters
}
