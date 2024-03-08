package com.PFE.Microservice.DTO;

import jakarta.validation.constraints.NotNull;
import java.util.Date;
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

    // Getters and Setters
}
