package Attestation.attestation03.src.main.java.com.jkhproject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import Attestation.attestation03.src.main.java.com.jkhproject.model.Meter;
import Attestation.attestation03.src.main.java.com.jkhproject.service.MeterService;

import java.util.List;

@RestController
@RequestMapping("/api/meters")
@RequiredArgsConstructor
public class MeterController {
    private final MeterService meterService;

    @PostMapping
    public ResponseEntity<Meter> create(@RequestBody Meter meter) {
        return ResponseEntity.status(HttpStatus.CREATED).body(meterService.create(meter));
    }

    @GetMapping("/owner/{ownerId}")
    public ResponseEntity<List<Meter>> getByOwner(@PathVariable Long ownerId) {
        return ResponseEntity.ok(meterService.getAllByOwner(ownerId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Meter> get(@PathVariable Long id) {
        return ResponseEntity.ok(meterService.get(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Meter> update(@PathVariable Long id, @RequestBody Meter meter) {
        return ResponseEntity.ok(meterService.update(id, meter));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        meterService.softDelete(id);
        return ResponseEntity.noContent().build();
    }
}
