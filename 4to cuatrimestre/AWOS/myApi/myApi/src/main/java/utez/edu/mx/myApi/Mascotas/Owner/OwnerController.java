package utez.edu.mx.myApi.Mascotas.Owner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping("/api/petShop/Owners")
public class OwnerController {
    @Autowired
    private OwnerService ownerService;

    @GetMapping("")
    public ResponseEntity<?> findAll() {
        return ownerService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable long id) {
        return ownerService.findById(id);
    }

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody Owner owner) {
        return ownerService.save(owner);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Owner owner ,@PathVariable long id) {
        return ownerService.update(owner, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        return ownerService.delete(id);
    }

}
