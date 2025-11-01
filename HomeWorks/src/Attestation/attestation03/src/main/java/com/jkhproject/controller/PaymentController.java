package Attestation.attestation03.src.main.java.com.jkhproject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import Attestation.attestation03.src.main.java.com.jkhproject.model.Payment;
import Attestation.attestation03.src.main.java.com.jkhproject.service.PaymentService;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;

    @PostMapping
    public ResponseEntity<Payment> create(@RequestBody Payment payment) {
        return ResponseEntity.status(HttpStatus.CREATED).body(paymentService.create(payment));
    }

    @GetMapping("/owner/{ownerId}")
    public ResponseEntity<List<Payment>> getByOwner(@PathVariable Long ownerId) {
        return ResponseEntity.ok(paymentService.getAllByOwner(ownerId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Payment> get(@PathVariable Long id) {
        return ResponseEntity.ok(paymentService.get(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Payment> update(@PathVariable Long id, @RequestBody Payment payment) {
        return ResponseEntity.ok(paymentService.update(id, payment));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        paymentService.softDelete(id);
        return ResponseEntity.noContent().build();
    }
}
