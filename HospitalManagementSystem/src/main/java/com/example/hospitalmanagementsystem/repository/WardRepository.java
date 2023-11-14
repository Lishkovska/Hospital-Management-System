package com.example.hospitalmanagementsystem.repository;

import com.example.hospitalmanagementsystem.models.entity.NurseEntity;
import com.example.hospitalmanagementsystem.models.entity.Ward;
import com.example.hospitalmanagementsystem.models.enums.WardEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WardRepository extends JpaRepository<Ward, Long> {
    Optional<Ward> findByName(WardEnum wardEnum);

    @Query("SELECT w FROM Ward w" + " ORDER BY size(w.patientList) ASC ")
    List<Ward> findAllByAndCount();
}
