package utez.edu.mx.paqueteria.modules.article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import utez.edu.mx.paqueteria.modules.article.DTO.ArticlePacketDTO;
import utez.edu.mx.paqueteria.modules.article.DTO.ArticleQuantityDTO;
import utez.edu.mx.paqueteria.utils.CustomResponseEntity;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private CustomResponseEntity customResponseEntity;

    public ArticlePacketDTO transformArticleToDTOForPacket(Article a){
        return new ArticlePacketDTO(
                a.getId(),
                a.getName(),
                a.getDescription()
        );
    }

    public List<ArticlePacketDTO> transformArticleToDTOsForPacket(List<Article> articles){
        List<ArticlePacketDTO> list = new ArrayList<>();
        for (Article a : articles){
            list.add(transformArticleToDTOForPacket(a));
        }
        return list;
    }

    @Transactional(readOnly = true)
    public ResponseEntity<?> findAll(){
        List<Article> list = articleRepository.findAll();
        return customResponseEntity.getOkResponse(
                list.isEmpty() ? "Aún no hay registros" : "Operación exitosa",
                "OK",
                200,
                list
        );
    }

    @Transactional(readOnly = true)
    public ResponseEntity<?> findById(long idArticle){
        Article found = articleRepository.findById(idArticle);
        if (found == null){
            return customResponseEntity.get404Response();
        } else {
            return customResponseEntity.getOkResponse(
                    "Operación exitosa",
                    "OK",
                    200,
                    found
            );
        }
    }

    @Transactional(rollbackFor = {SQLException.class, Exception.class})
    public ResponseEntity<?> save(Article article) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm", new Locale("es-MX"));
        Date currentDay = new Date();

        try {
            article.setRegisteredOn(sdf.format(currentDay));
            articleRepository.save(article);
            return customResponseEntity.getOkResponse(
                    "Registro exitoso",
                    "CREATED",
                    201,
                    null
            );
        } catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            return customResponseEntity.get400Response();
        }
    }

    @Transactional(rollbackFor = {SQLException.class, Exception.class})
    public ResponseEntity<?> update(Article article){
        Article found = articleRepository.findById(article.getId());
        if (found == null){
            return customResponseEntity.get404Response();
        } else {
            try {
                articleRepository.save(article);
                return customResponseEntity.getOkResponse(
                        "Actualización exitosa",
                        "OK",
                        200,
                        null
                );
            }catch (Exception e){
                e.printStackTrace();
                System.out.println(e.getMessage());
                return customResponseEntity.get400Response();
            }
        }
    }

    @Transactional(rollbackFor = {SQLException.class, Exception.class})
    public ResponseEntity<?> incrementStockByQuantity(ArticleQuantityDTO data){
        if (articleRepository.findById(data.getId()) == null){
            return customResponseEntity.get404Response();
        } else {
            try {
                articleRepository.incrementStockByQuantity(data.getQuantity(), data.getId());
                return customResponseEntity.getOkResponse(
                        "Se aumentó el stock del artículo",
                        "OK",
                        200,
                        null
                );
            }catch (Exception e){
                e.printStackTrace();
                System.out.println(e.getMessage());
                return customResponseEntity.get400Response();
            }
        }
    }

    @Transactional(rollbackFor = {SQLException.class, Exception.class})
    public void decrementStockById(long idArticle){
        if (articleRepository.findById(idArticle) == null){
            System.out.println("El id del articulo no existe");
        } else {
            try {
                articleRepository.decrementStockById(idArticle);
            } catch (Exception e){
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
        }
    }


}
