package utez.edu.mx.myApi.Mascotas.Owner;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import utez.edu.mx.myApi.Mascotas.Pet.Pet;

@Entity
@Table(name = "owner")
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fullName", nullable = false)
    private String fullName;

    @Column(name = "phone", nullable = false)
    private String phone;

    @OneToOne(mappedBy = "owner", cascade = CascadeType.ALL)
    @JsonIgnore
    private Pet pet;

    public Owner() {
    }

    public Owner(Long id, String fullName, String phone, Pet pet) {
        this.id = id;
        this.fullName = fullName;
        this.phone = phone;
        this.pet = pet;
    }

    public Owner(Long id, String fullName, String phone) {
        this.id = id;
        this.fullName = fullName;
        this.phone = phone;
    }

    public Owner(String fullName, String phone) {
        this.fullName = fullName;
        this.phone = phone;
    }

    // Getters and setters...
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }
}
