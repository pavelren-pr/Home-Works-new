package com.jkhproject.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "owner")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name")
    private String fullName;
    private String apartmentNumber;
    private String address;
    private String phone;

    private Boolean isActive = true;
}