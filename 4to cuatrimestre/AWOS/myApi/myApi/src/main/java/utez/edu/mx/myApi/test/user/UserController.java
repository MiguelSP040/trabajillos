package utez.edu.mx.myApi.test.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
    @RequestMapping("/api/user")
    public class UserController {
        @Autowired
        private UserService userService;

        @GetMapping("")
        public ResponseEntity<?> findAll() {
            return userService.findAll();
        }

        @GetMapping("/{id}")
        public ResponseEntity<?> findById(@PathVariable long id) {
            return userService.findById(id);
        }

        @PostMapping("")
        public ResponseEntity<?> save(@RequestBody User user) {
            return userService.save(user);
        }

        @PutMapping("/{id}")
        public ResponseEntity<?> update(@RequestBody User user, @PathVariable long id) {
            return userService.update(user, id);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<?> delete(@PathVariable long id) {
            return userService.delete(id);
        }

    }
