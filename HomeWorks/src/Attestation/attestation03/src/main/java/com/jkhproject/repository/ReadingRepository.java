package com.jkhproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jkhproject.model.Reading;

import java.util.List;

public interface ReadingRepository extends JpaRepository<Reading, Long> {
    List<Reading> findByMeterIdAndIsActiveTrue(Long meterId);
}
