package utez.edu.mx.myApi.Mascotas.Type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/petShop/type")
@CrossOrigin(origins = {"*"})
public class TypeController {
    @Autowired
    private TypeService typeService;

    @GetMapping("")
    public ResponseEntity<?> findAll() {
        return typeService.findAll();
    }
}
