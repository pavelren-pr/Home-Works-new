package com.jkhproject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import com.jkhproject.model.Owner;
import com.jkhproject.service.OwnerService;

import java.util.List;

@RestController
@RequestMapping("/api/owners")
@RequiredArgsConstructor
public class OwnerController {
    private final OwnerService ownerService;

    @PostMapping
    public ResponseEntity<Owner> create(@RequestBody Owner owner) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ownerService.create(owner));
    }

    @GetMapping
    public ResponseEntity<List<Owner>> getAll() {
        return ResponseEntity.ok(ownerService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Owner> get(@PathVariable Long id) {
        return ResponseEntity.ok(ownerService.get(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Owner> update(@PathVariable Long id, @RequestBody Owner owner) {
        return ResponseEntity.ok(ownerService.update(id, owner));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        ownerService.softDelete(id);
        return ResponseEntity.noContent().build();
    }
}
