package Attestation.attestation03.src.main.java.com.jkhproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import Attestation.attestation03.src.main.java.com.jkhproject.model.Reading;

import java.util.List;

public interface ReadingRepository extends JpaRepository<Reading, Long> {
    List<Reading> findByMeterIdAndIsActiveTrue(Long meterId);
}
