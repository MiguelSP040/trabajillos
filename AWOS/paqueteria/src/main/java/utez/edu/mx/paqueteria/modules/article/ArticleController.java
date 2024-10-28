package utez.edu.mx.paqueteria.modules.article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utez.edu.mx.paqueteria.modules.article.DTO.ArticleQuantityDTO;

@RestController
@RequestMapping("/api/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("")
    public ResponseEntity<?> findAll(){
        return articleService.findAll();
    }

    @GetMapping("/{idArticle}")
    public ResponseEntity<?> findById(@PathVariable("idArticle") long idArticle){
        return articleService.findById(idArticle);
    }

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody Article article){
        return articleService.save(article);
    }

    @PutMapping("")
    public ResponseEntity<?> update(@RequestBody Article article){
        return articleService.update(article);
    }

    @PutMapping("/quantity")
    public ResponseEntity<?> incrementStockByQuantity(@RequestBody ArticleQuantityDTO articleQuantityDTO){
        return articleService.incrementStockByQuantity(articleQuantityDTO);
    }
}
