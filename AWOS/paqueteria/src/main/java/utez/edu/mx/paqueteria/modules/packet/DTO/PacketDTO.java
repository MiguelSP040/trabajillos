package utez.edu.mx.paqueteria.modules.packet.DTO;

import utez.edu.mx.paqueteria.modules.article.DTO.ArticlePacketDTO;
import utez.edu.mx.paqueteria.modules.user.DTO.UserPacketDTO;

import java.util.List;

public class PacketDTO {
    private long id;
    private String orderedOn;
    private boolean delivered;
    private int status;
    private UserPacketDTO user;
    private List<ArticlePacketDTO> articles;

    public PacketDTO() {
    }

    public PacketDTO(long id, String orderedOn, boolean delivered, int status, UserPacketDTO user, List<ArticlePacketDTO> articles) {
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

    public UserPacketDTO getUser() {
        return user;
    }

    public void setUser(UserPacketDTO user) {
        this.user = user;
    }

    public List<ArticlePacketDTO> getArticles() {
        return articles;
    }

    public void setArticles(List<ArticlePacketDTO> articles) {
        this.articles = articles;
    }
}
