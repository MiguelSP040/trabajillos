package utez.edu.mx.paqueteria.modules.packet;

import jakarta.persistence.*;
import utez.edu.mx.paqueteria.modules.article.Article;
import utez.edu.mx.paqueteria.modules.user.User;

import java.util.List;

@Entity
@Table(name = "packet")
public class Packet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "ordered_on", nullable = false)
    private String orderedOn;

    @Column(name = "delivered", nullable = false)
    private boolean delivered;

    @Column(name = "status", nullable = false)
    private int status;

    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    private User user;

    @ManyToMany
    @JoinTable(
            name = "packet_has_articles",
            joinColumns = @JoinColumn(name = "id_packet"),
            inverseJoinColumns = @JoinColumn(name = "id_article")
    )
    private List<Article> articles;

    public Packet() {
    }

    public Packet(String orderedOn, boolean delivered, int status) {
        this.orderedOn = orderedOn;
        this.delivered = delivered;
        this.status = status;
    }

    public Packet(long id, String orderedOn, boolean delivered, int status) {
        this.id = id;
        this.orderedOn = orderedOn;
        this.delivered = delivered;
        this.status = status;
    }

    public Packet(String orderedOn, boolean delivered, int status, User user, List<Article> articles) {
        this.orderedOn = orderedOn;
        this.delivered = delivered;
        this.status = status;
        this.user = user;
        this.articles = articles;
    }

    public Packet(long id, String orderedOn, boolean delivered, int status, User user, List<Article> articles) {
        this.id = id;
        this.orderedOn = orderedOn;
        this.delivered = delivered;
        this.status = status;
        this.user = user;
        this.articles = articles;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOrderedOn() {
        return orderedOn;
    }

    public void setOrderedOn(String orderedOn) {
        this.orderedOn = orderedOn;
    }

    public boolean isDelivered() {
        return delivered;
    }

    public void setDelivered(boolean delivered) {
        this.delivered = delivered;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
}
