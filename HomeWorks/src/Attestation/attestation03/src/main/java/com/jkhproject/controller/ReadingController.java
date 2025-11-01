package Attestation.attestation03.src.main.java.com.jkhproject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import Attestation.attestation03.src.main.java.com.jkhproject.model.Reading;
import Attestation.attestation03.src.main.java.com.jkhproject.service.ReadingService;

import java.util.List;

@RestController
@RequestMapping("/api/readings")
@RequiredArgsConstructor
public class ReadingController {
    private final ReadingService readingService;

    @PostMapping
    public ResponseEntity<Reading> create(@RequestBody Reading reading) {
        return ResponseEntity.status(HttpStatus.CREATED).body(readingService.create(reading));
    }

    @GetMapping("/meter/{meterId}")
    public ResponseEntity<List<Reading>> getByMeter(@PathVariable Long meterId) {
        return ResponseEntity.ok(readingService.getAllByMeter(meterId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reading> get(@PathVariable Long id) {
        return ResponseEntity.ok(readingService.get(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reading> update(@PathVariable Long id, @RequestBody Reading reading) {
        return ResponseEntity.ok(readingService.update(id, reading));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        readingService.softDelete(id);
        return ResponseEntity.noContent().build();
    }
}

