package com.example.hospitalmanagementsystem.models.entity;

import com.example.hospitalmanagementsystem.models.enums.RoleEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private RoleEnum  role;

    public Long getId(){
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RoleEnum getRole() {
        return role;
    }

    public void setRole(RoleEnum role) {
        this.role = role;
    }

    public UserRole() {
    }
}
