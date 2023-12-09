package com.example.hospitalmanagementsystem.repository;

import com.example.hospitalmanagementsystem.models.entity.UserRole;
import com.example.hospitalmanagementsystem.models.enums.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

    Optional<List<UserRole>> findByRole(RoleEnum role);
    //Optional<UserRole> findUserRoleByRole(RoleEnum role);

}
