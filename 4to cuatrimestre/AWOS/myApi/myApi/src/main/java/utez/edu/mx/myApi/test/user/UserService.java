package utez.edu.mx.myApi.test.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
    public class UserService {
        @Autowired
        private UserRepository userRepository;

        @Transactional(readOnly = true)
        public ResponseEntity<?> findAll(){
            Map<String, Object> body = new HashMap<>();
            List<User> list = userRepository.findAll();

            body.put("message", list.isEmpty() ? "Aún no hay registros" : "Operación exitosa" );
            body.put("status", 200);
            body.put("data", list);

            return new ResponseEntity<>(body, HttpStatus.OK);
        }

        @Transactional(readOnly = true)
        public ResponseEntity<?> findById(long id){
            Map<String, Object> body = new HashMap<>();
            User found = userRepository.findById(id);

            body.put("message", found == null ? "Registro no encontrado" : "Operación exitosa" );
            body.put("status", found == null ? 404 : 200);
            body.put("data", found);

            return new ResponseEntity<>(body, found == null ? HttpStatus.BAD_REQUEST : HttpStatus.OK);
    }

        @Transactional(rollbackFor = {SQLException.class, Exception.class})
        public ResponseEntity<?> save(User user) {
            Map<String, Object> body = new HashMap<>();
            User saved = null;

            try {
                saved = userRepository.save(user);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
            }

            body.put("message", saved != null ? "Registro realizado exitosamente" : "Error en el registro");
            body.put("status", saved != null ? 201 : 400);
            return new ResponseEntity<>(body, saved != null ? HttpStatus.OK : HttpStatus.BAD_REQUEST);

    }

    @Transactional(rollbackFor = {SQLException.class, Exception.class})
    public ResponseEntity<?> update(User user, long id) {
        Map<String, Object> body = new HashMap<>();
        User updated = null;

        if (userRepository.findById(id) != null) {
            user.setId(id);
            try {
                updated = userRepository.save(user);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
            body.put("message", updated != null ? "Actualización realizada exitosamente" : "Error en la actualización");
            body.put("status", updated != null ? 201 : 400);
            return new ResponseEntity<>(body, updated != null ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
        }else {
            body.put("message", "El registro no existe");
            body.put("status", 404);
            return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
        }
    }
    @Transactional(rollbackFor = {SQLException.class, Exception.class})
    public ResponseEntity<?> delete(long id) {
            Map<String, Object> body = new HashMap<>();

            if (userRepository.findById(id) != null) {
                try {
                    userRepository.deleteById(id);
                    body.put("message", "Eliminación realizada exitosamente");
                    body.put("status", 200);
                    return new ResponseEntity<>(body, HttpStatus.OK);

                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println(e.getMessage());
                    body.put("message", "Error en la eliminación");
                    body.put("status", 400);
                    return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
                }

            } else {
                body.put("message", "El registro no existe");
                body.put("status", 404);
                return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
            }
    }
}
