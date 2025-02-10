package utez.edu.mx.paqueteria.modules.article;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import utez.edu.mx.paqueteria.modules.packet.Packet;
import java.util.List;

@Entity
@Table(name = "article")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "on_stock", nullable = false, columnDefinition = "BIGINT DEFAULT 0")
    private long onStock;

    @Column(name = "registered_on", nullable = false)
    private String registeredOn;

    @ManyToMany(mappedBy = "articles")
    @JsonIgnore
    private List<Packet> packets;

    public Article() {
    }

    public Article(String name, String description, long onStock) {
        this.name = name;
        this.description = description;
        this.onStock = onStock;
    }

    public Article(int id, String name, String description, long onStock) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.onStock = onStock;
    }

    public Article(String name, String description, long onStock, String registeredOn, List<Packet> packets) {
        this.name = name;
        this.description = description;
        this.onStock = onStock;
        this.registeredOn = registeredOn;
        this.packets = packets;
    }

    public Article(int id, String name, String description, long onStock, String registeredOn, List<Packet> packets) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.onStock = onStock;
        this.registeredOn = registeredOn;
        this.packets = packets;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public long getOnStock() {
        return onStock;
    }

    public void setOnStock(long onStock) {
        this.onStock = onStock;
    }

    public String getRegisteredOn() {
        return registeredOn;
    }

    public void setRegisteredOn(String registeredOn) {
        this.registeredOn = registeredOn;
    }

    public List<Packet> getPackets() {
        return packets;
    }

    public void setPackets(List<Packet> packets) {
        this.packets = packets;
    }
}
