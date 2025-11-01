package Attestation.attestation03.src.main.java.com.jkhproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import Attestation.attestation03.src.main.java.com.jkhproject.model.Meter;

import java.util.List;

public interface MeterRepository extends JpaRepository<Meter, Long> {
    List<Meter> findByOwnerIdAndIsActiveTrue(Long ownerId);
}
