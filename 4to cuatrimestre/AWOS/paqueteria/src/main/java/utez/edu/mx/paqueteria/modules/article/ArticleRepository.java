package utez.edu.mx.paqueteria.modules.article;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
    List<Article> findAll();

    Article findById(long id);

    Article save(Article article);

    @Modifying
    @Query(value = "UPDATE article SET on_stock = on_stock + :quantity WHERE id = :idArticle;", nativeQuery = true)
    void incrementStockByQuantity(@Param("quantity") long quantity, @Param("idArticle") long idArticle);

    @Modifying
    @Query(value = "UPDATE article SET on_stock = on_stock - 1 WHERE id = :idArticle;", nativeQuery = true)
    void decrementStockById(@Param("idArticle") long idArticle);
}
