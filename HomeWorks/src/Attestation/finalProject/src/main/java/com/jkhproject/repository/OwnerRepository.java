package com.jkhproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jkhproject.model.Owner;

import java.util.List;

public interface OwnerRepository extends JpaRepository<Owner, Long> {
    List<Owner> findByIsActiveTrue();
}
