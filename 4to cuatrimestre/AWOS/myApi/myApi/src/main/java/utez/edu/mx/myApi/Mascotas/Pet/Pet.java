package utez.edu.mx.myApi.Mascotas.Pet;

import jakarta.persistence.*;
import utez.edu.mx.myApi.Mascotas.Building.Building;
import utez.edu.mx.myApi.Mascotas.Owner.Owner;
import utez.edu.mx.myApi.Mascotas.Type.Type;


import java.util.List;

@Entity
@Table(name = "pet")
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nickname", nullable = false)
    private String nickname;

    @ManyToOne
    @JoinColumn(name = "idType", nullable = false)
    private Type type;

    @OneToOne
    @JoinColumn(name = "idOwner", referencedColumnName = "id", unique = true, nullable = false)
    private Owner owner;

    @ManyToMany
    @JoinTable(
            name = "PetIsInBuilding",
            joinColumns = @JoinColumn(name = "idPet"),
            inverseJoinColumns = @JoinColumn(name = "idBuilding")
    )
    private List<Building> buildings;

    public Pet() {
    }

    public Pet(Long id, String nickname, Type type, Owner owner, List<Building> buildings) {
        this.id = id;
        this.nickname = nickname;
        this.type = type;
        this.owner = owner;
        this.buildings = buildings;
    }

    public Pet(Long id, String nickname) {
        this.id = id;
        this.nickname = nickname;
    }

    public Pet(String nickname) {
        this.nickname = nickname;
    }

    public Pet(String nickname, Type type, Owner owner, List<Building> buildings) {
        this.nickname = nickname;
        this.type = type;
        this.owner = owner;
        this.buildings = buildings;
    }

    public Pet(String nickname, Type type, Owner owner) {
        this.nickname = nickname;
        this.type = type;
        this.owner = owner;
    }

    public Pet(Long id, String nickname, Type type, Owner owner) {
        this.id = id;
        this.nickname = nickname;
        this.type = type;
        this.owner = owner;
    }

    // Getters and Setters...

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public List<Building> getBuildings() {
        return buildings;
    }

    public void setBuildings(List<Building> buildings) {
        this.buildings = buildings;
    }
}
