package com.PFE.Microservice.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
@Table(name = "conges")
public class Conges {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date startDate;
    private Date endDate;

    // Many Conges can be associated with one Contact
    @ManyToOne
    @JoinColumn(name = "contact_id")
    private Contact contact;

    // Getters and Setters
}
