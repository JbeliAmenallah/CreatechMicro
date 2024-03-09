package com.PFE.Microservice.DTO;

import jakarta.validation.constraints.NotNull;
import java.util.Date;

import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CongesDTO {
    @NotNull(message = "The start date of Conges is required")
    private Date startDate;

    @NotNull(message = "The end date of Conges is required")
    private Date endDate;

    @NotNull(message = "The Conges's contact ID is required")
    private Long contactId;
    private String contactName;
    @NotNull(message = "The state of the congé is required")
    @Size(max = 50, message = "The state of the congé must not exceed {max} characters")
    private String state; // New attribute
    // Getters and Setters
}
