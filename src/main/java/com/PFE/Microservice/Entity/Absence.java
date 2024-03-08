package com.PFE.Microservice.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
@Table(name = "absence")
public class Absence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dateOfAbsence;
    private String reason;
    @ManyToOne
    @JoinColumn(name = "contact_id")
    private Contact contact;

    // Getters and Setters
}
