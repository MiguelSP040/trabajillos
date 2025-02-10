package com.superheros.ingrid.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity //Define la clase como una entidad para Spring
@Table(name = "super_power") //Atributos y características para la ORM
@AllArgsConstructor
@NoArgsConstructor
public class SuperPowerEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //Define el ID
    private Integer id;
    private String name;
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}