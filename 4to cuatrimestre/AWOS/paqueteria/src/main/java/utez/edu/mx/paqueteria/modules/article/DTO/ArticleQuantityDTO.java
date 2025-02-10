package utez.edu.mx.paqueteria.modules.article.DTO;

public class ArticleQuantityDTO {
    private long id, quantity;

    public ArticleQuantityDTO() {
    }

    public ArticleQuantityDTO(long id, long quantity) {
        this.id = id;
        this.quantity = quantity;
    }

    public long getId() {   
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }
}
