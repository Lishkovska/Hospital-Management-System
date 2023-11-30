package com.example.hospitalmanagementsystem.models.entity;

import com.example.hospitalmanagementsystem.models.enums.TypeOfMenu;
import jakarta.persistence.*;

@Entity
@Table(name = "kitchens")
public class KitchenCatering extends BaseEntity{
    @Column(nullable = false, name = "type_of_menu")
    @Enumerated(EnumType.STRING)
    private TypeOfMenu typeOfMenu;
    @Column(name = "diet_number")
    private String dietNumber;

    public KitchenCatering() {
    }

    public TypeOfMenu getTypeOfMenu() {
        return typeOfMenu;
    }

    public void setTypeOfMenu(TypeOfMenu typeOfMenu) {
        this.typeOfMenu = typeOfMenu;
    }

    public String getDietNumber() {
        return dietNumber;
    }

    public void setDietNumber(String dietNumber) {
        this.dietNumber = dietNumber;
    }
}
