package com.PFE.Microservice.DTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ContactDTO {
    private Long id;

    @NotNull(message = "The contact's name is required")
    @Size(max = 255, message = "The contact's name must not exceed {max} characters")
    private String name;

    @NotNull(message = "The contact's phone number is required")
    @Size(max = 20, message = "The contact's phone number must not exceed {max} characters")
    private String phone;

    @NotNull(message = "The contact's email address is required")
    @Size(max = 255, message = "The contact's email address must not exceed {max} characters")
    private String mailAddress;

    @NotNull(message = "The contact's age is required")
    private int age;

    @NotNull(message = "The contact's degree is required")
    @Size(max = 50, message = "The contact's degree must not exceed {max} characters")
    private String degree;

    // Getters and Setters
}
