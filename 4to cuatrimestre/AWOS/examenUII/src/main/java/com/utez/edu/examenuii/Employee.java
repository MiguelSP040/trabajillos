package com.utez.edu.examenuii;

import jakarta.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "status", nullable = false)
    private boolean status;

    @Column(name = "registered_on", nullable = false)
    private String registeredOn;

    @ManyToOne
    @JoinColumn(name = "id_department", nullable = false)
    private Department department;

    public Employee() {
    }

    public Employee(String name, String surname, String lastname, boolean status, String registeredOn) {
        this.name = name;
        this.surname = surname;
        this.lastname = lastname;
        this.status = status;
        this.registeredOn = registeredOn;
    }

    public Employee(long id, String name, String surname, String lastname, boolean status, String registeredOn) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.lastname = lastname;
        this.status = status;
        this.registeredOn = registeredOn;
    }

    public Employee(long id, Department department) {
        this.id = id;
        this.department = department;
    }

    public Employee(long id, String name, String surname, String lastname, boolean status, String registeredOn, Department department) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.lastname = lastname;
        this.status = status;
        this.registeredOn = registeredOn;
        this.department = department;
    }

    public long getId() {
        return id;
    }

    public Employee setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Employee setName(String name) {
        this.name = name;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public Employee setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public String getLastname() {
        return lastname;
    }

    public Employee setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public boolean isStatus() {
        return status;
    }

    public Employee setStatus(boolean status) {
        this.status = status;
        return this;
    }

    public String getRegisteredOn() {
        return registeredOn;
    }

    public Employee setRegisteredOn(String registeredOn) {
        this.registeredOn = registeredOn;
        return this;
    }

    public Department getDepartment() {
        return department;
    }

    public Employee setDepartment(Department department) {
        this.department = department;
        return this;
    }
}
