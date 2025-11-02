package com.jkhproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jkhproject.model.Meter;

import java.util.List;

public interface MeterRepository extends JpaRepository<Meter, Long> {
    List<Meter> findByOwnerIdAndIsActiveTrue(Long ownerId);
}
