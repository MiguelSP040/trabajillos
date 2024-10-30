package utez.edu.mx.paqueteria.modules.article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import utez.edu.mx.paqueteria.modules.article.DTO.ArticleQuantityDTO;

@RestController
@RequestMapping("/api/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("")
    @Secured({"ROLE_ADMIN", "ROLE_EMPLOYEE", "ROLE_CUSTOMER"})
    public ResponseEntity<?> findAll(){
        return articleService.findAll();
    }

    @GetMapping("/{idArticle}")
    @Secured({"ROLE_ADMIN", "ROLE_EMPLOYEE", "ROLE_CUSTOMER"})
    public ResponseEntity<?> findById(@PathVariable("idArticle") long idArticle){
        return articleService.findById(idArticle);
    }

    @PostMapping("")
    @Secured({"ROLE_ADMIN", "ROLE_EMPLOYEE"})
    public ResponseEntity<?> save(@RequestBody Article article){
        return articleService.save(article);
    }

    @PutMapping("")
    @Secured({"ROLE_ADMIN", "ROLE_EMPLOYEE"})
    public ResponseEntity<?> update(@RequestBody Article article){
        return articleService.update(article);
    }

    @PutMapping("/quantity")
    @Secured({"ROLE_ADMIN", "ROLE_EMPLOYEE"})
    public ResponseEntity<?> incrementStockByQuantity(@RequestBody ArticleQuantityDTO articleQuantityDTO){
        return articleService.incrementStockByQuantity(articleQuantityDTO);
    }
}
