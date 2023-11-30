package com.example.hospitalmanagementsystem.repository;

import com.example.hospitalmanagementsystem.models.entity.NurseEntity;
import com.example.hospitalmanagementsystem.models.entity.Patient;
import com.example.hospitalmanagementsystem.models.enums.WardEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
   Optional<Patient> findAllByNurseId(Long id);

}
