package com.superheros.ingrid.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "superheroes")
//@Data //Lombok implementa los metodos getters y setters ademas de .toString()
@AllArgsConstructor //Se utiliza para implementar un constructor con todos los atributos de la clase
@NoArgsConstructor //Se utiliza para implementar un constructor sin atributos
public class SuperheroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

   
    @Column(name = "name")
    private String name;

    @Column(name = "real_name")
    private String realName;

    @ManyToOne
    @JoinColumn(name = "super_power_id")
    private SuperPowerEntity superPower;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private CityEntity cityEntity;

    /*@Column(name = "power", nullable = false)
    private double power;*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public SuperPowerEntity getSuperPower() {
        return superPower;
    }

    public void setSuperPower(SuperPowerEntity superPower) {
        this.superPower = superPower;
    }

    public CityEntity getCityEntity() {
        return cityEntity;
    }

    public SuperheroEntity setCityEntity(CityEntity cityEntity) {
        this.cityEntity = cityEntity;
        return this;
    }
}