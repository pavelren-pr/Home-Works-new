package com.jkhproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jkhproject.model.Payment;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    List<Payment> findByOwnerIdAndIsActiveTrue(Long ownerId);
}
