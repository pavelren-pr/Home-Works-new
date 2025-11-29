package com.jkhproject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.jkhproject.model.Reading;
import com.jkhproject.repository.ReadingRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReadingService {
    private final ReadingRepository readingRepository;

    public Reading create(Reading reading) {
        return readingRepository.save(reading);
    }

    public List<Reading> getAllByMeter(Long meterId) {
        return readingRepository.findByMeterIdAndIsActiveTrue(meterId);
    }

    public Reading get(Long id) {
        return readingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reading not found"));
    }

    public Reading update(Long id, Reading updated) {
        Reading r = get(id);
        r.setReadingValue(updated.getReadingValue());
        r.setReadingDate(updated.getReadingDate());
        return readingRepository.save(r);
    }

    public void softDelete(Long id) {
        Reading r = get(id);
        r.setIsActive(false);
        readingRepository.save(r);
    }
}
