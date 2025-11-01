package Attestation.attestation03.src.main.java.com.jkhproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import Attestation.attestation03.src.main.java.com.jkhproject.model.Payment;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    List<Payment> findByOwnerIdAndIsActiveTrue(Long ownerId);
}
