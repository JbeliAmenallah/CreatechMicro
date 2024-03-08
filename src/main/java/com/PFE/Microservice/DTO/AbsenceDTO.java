package com.PFE.Microservice.DTO;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.Date;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AbsenceDTO {
    @NotNull(message = "The Absence date is required")
    @Size(max = 255, message = "The contact's name must not exceed {max} characters")
    private Date dateOfAbsence;
    @NotNull(message = "The Absence is required")
    @Size(max = 255, message = "The contact's name must not exceed {max} characters")
    private String reason;
    @NotNull(message = "The Absence's contact ID is required")
    @Size(max = 255, message = "The contact's name must not exceed {max} characters")
    private Long contactId;

    // Getters and Setters
}
