package com.jkhproject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.jkhproject.model.Payment;
import com.jkhproject.repository.PaymentRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final PaymentRepository paymentRepository;

    public Payment create(Payment payment) {
        return paymentRepository.save(payment);
    }

    public List<Payment> getAllByOwner(Long ownerId) {
        return paymentRepository.findByOwnerIdAndIsActiveTrue(ownerId);
    }

    public Payment get(Long id) {
        return paymentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment not found"));
    }

    public Payment update(Long id, Payment updated) {
        Payment p = get(id);
        p.setMonth(updated.getMonth());
        p.setAmount(updated.getAmount());
        p.setStatus(updated.getStatus());
        return paymentRepository.save(p);
    }

    public void softDelete(Long id) {
        Payment p = get(id);
        p.setIsActive(false);
        paymentRepository.save(p);
    }
}
