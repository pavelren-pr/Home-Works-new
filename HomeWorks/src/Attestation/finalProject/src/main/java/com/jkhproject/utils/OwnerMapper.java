package com.jkhproject.utils;

import Attestation.attestation03.src.main.java.com.jkhproject.dto.OwnerDto;
import Attestation.attestation03.src.main.java.com.jkhproject.model.Owner;

public class OwnerMapper {
    public static OwnerDto toDto(Owner owner) {
        OwnerDto dto = new OwnerDto();
        dto.setId(owner.getId());
        dto.setFullName(owner.getFullName());
        dto.setApartmentNumber(owner.getApartmentNumber());
        dto.setAddress(owner.getAddress());
        dto.setPhone(owner.getPhone());
        return dto;
    }

    public static Owner toEntity(OwnerDto dto) {
        return Owner.builder()
                .id(dto.getId())
                .fullName(dto.getFullName())
                .apartmentNumber(dto.getApartmentNumber())
                .address(dto.getAddress())
                .phone(dto.getPhone())
                .build();
    }
}
