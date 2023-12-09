package com.example.hospitalmanagementsystem.repository;

import com.example.hospitalmanagementsystem.models.entity.NurseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NurseRepository extends JpaRepository<NurseEntity, Long> {
    Optional<NurseEntity> findByUsername(String username);
    Optional<NurseEntity> findAllById(Long id);



}
