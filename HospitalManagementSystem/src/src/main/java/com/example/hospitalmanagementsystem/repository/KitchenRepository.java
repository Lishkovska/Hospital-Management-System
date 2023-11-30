package com.example.hospitalmanagementsystem.repository;

import com.example.hospitalmanagementsystem.models.entity.KitchenCatering;
import com.example.hospitalmanagementsystem.models.enums.TypeOfMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface KitchenRepository extends JpaRepository<KitchenCatering, Long> {
    Optional<KitchenCatering> findByTypeOfMenu(TypeOfMenu typeOfMenu);
}
