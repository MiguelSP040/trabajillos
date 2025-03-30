package utez.edu.mx.myApi.Mascotas.Pet;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping("/api/petShop")
public class PetController {
    @Autowired
    private PetService petService;

    @GetMapping("")
    public ResponseEntity<?> findAll() {
        return petService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable long id) {
        return petService.findById(id);
    }

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody Pet pet) {
        return petService.save(pet);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Pet pet, @PathVariable Long id) {
        return petService.update(pet, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return petService.delete(id);
    }
}
