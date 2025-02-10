package utez.edu.mx.paqueteria.modules.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("")
    @Secured("ROLE_ADMIN")
    public ResponseEntity<?> findAll(){
        return userService.findAll();
    }

    @GetMapping("/rol/{idRol}")
    @Secured({"ROLE_ADMIN", "ROLE_EMPLOYEE"})
    public ResponseEntity<?> findByIdRol(@PathVariable("idRol") int idRol){
        return userService.findByIdRol(idRol);
    }

    @GetMapping("/{idUser}")
    @Secured("ROLE_ADMIN")
    public ResponseEntity<?> findById(@PathVariable("idUser") long idUser){
        return userService.findById(idUser);
    }

    @PostMapping("")
    @Secured("ROLE_ADMIN")
    public ResponseEntity<?> save(@RequestBody User user){
        return userService.save(user);
    }

    @PutMapping("")
    @Secured("ROLE_ADMIN")
    public ResponseEntity<?> update(@RequestBody User user){
        return userService.update(user);
    }

    @DeleteMapping("")
    public ResponseEntity<?> deleteById(@RequestBody User user){
        return userService.deleteById(user);
    }
}
