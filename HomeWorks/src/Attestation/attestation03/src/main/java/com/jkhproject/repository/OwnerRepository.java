package Attestation.attestation03.src.main.java.com.jkhproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import Attestation.attestation03.src.main.java.com.jkhproject.model.Owner;

import java.util.List;

public interface OwnerRepository extends JpaRepository<Owner, Long> {
    List<Owner> findByIsActiveTrue();
}
