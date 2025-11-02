package com.jkhproject.dto;

import lombok.Data;

@Data
public class OwnerDto {
    private Long id;
    private String fullName;
    private String apartmentNumber;
    private String address;
    private String phone;
}
