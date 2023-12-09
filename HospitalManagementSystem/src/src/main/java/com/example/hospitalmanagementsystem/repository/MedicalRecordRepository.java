package com.example.hospitalmanagementsystem.repository;

import com.example.hospitalmanagementsystem.models.entity.MedicalRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MedicalRecordRepository extends JpaRepository<MedicalRecord, Long> {
    @Override
    Optional<MedicalRecord> findById(Long id);
}
