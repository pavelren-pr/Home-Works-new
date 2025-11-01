package Attestation.attestation03.src.main.java.com.jkhproject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import Attestation.attestation03.src.main.java.com.jkhproject.model.Meter;
import Attestation.attestation03.src.main.java.com.jkhproject.repository.MeterRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MeterService {
    private final MeterRepository meterRepository;

    public Meter create(Meter meter) {
        return meterRepository.save(meter);
    }

    public List<Meter> getAllByOwner(Long ownerId) {
        return meterRepository.findByOwnerIdAndIsActiveTrue(ownerId);
    }

    public Meter get(Long id) {
        return meterRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Meter not found"));
    }

    public Meter update(Long id, Meter updated) {
        Meter meter = get(id);
        meter.setType(updated.getType());
        meter.setSerialNumber(updated.getSerialNumber());
        meter.setLastReading(updated.getLastReading());
        meter.setLastReadingDate(updated.getLastReadingDate());
        return meterRepository.save(meter);
    }

    public void softDelete(Long id) {
        Meter meter = get(id);
        meter.setIsActive(false);
        meterRepository.save(meter);
    }
}
