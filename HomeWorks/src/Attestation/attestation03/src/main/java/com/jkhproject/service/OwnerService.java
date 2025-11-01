package Attestation.attestation03.src.main.java.com.jkhproject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import Attestation.attestation03.src.main.java.com.jkhproject.model.Owner;
import Attestation.attestation03.src.main.java.com.jkhproject.repository.OwnerRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OwnerService {
    private final OwnerRepository ownerRepository;

    public Owner create(Owner owner) {
        return ownerRepository.save(owner);
    }

    public List<Owner> getAll() {
        return ownerRepository.findByIsActiveTrue();
    }

    public Owner get(Long id) {
        return ownerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Owner not found"));
    }

    public Owner update(Long id, Owner updated) {
        Owner owner = get(id);
        owner.setFullName(updated.getFullName());
        owner.setApartmentNumber(updated.getApartmentNumber());
        owner.setAddress(updated.getAddress());
        owner.setPhone(updated.getPhone());
        return ownerRepository.save(owner);
    }

    public void softDelete(Long id) {
        Owner owner = get(id);
        owner.setIsActive(false);
        ownerRepository.save(owner);
    }
}
