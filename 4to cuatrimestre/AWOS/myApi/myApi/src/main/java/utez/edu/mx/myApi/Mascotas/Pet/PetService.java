package utez.edu.mx.myApi.Mascotas.Pet;

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
public class PetService {
    @Autowired
    private PetRepository petRepository;

    @Transactional(readOnly = true)
    public ResponseEntity<?> findAll() {
        Map<String, Object> body = new HashMap<>();
        List<Pet> list = petRepository.findAll();

        body.put("message", list.isEmpty() ? "Aún no hay registros" : "Operación exitosa");
        body.put("code",200);
        body.put("status", "OK");
        body.put("data", list);

        return new ResponseEntity<>(body, HttpStatus.OK);
    }

    @Transactional(readOnly = true)
        public ResponseEntity<?> findById(long id) {
            Map<String, Object> body = new HashMap<>();
            Pet found = petRepository.findById(id);

            body.put("message", found == null ? "Registro no existente" : "Operación exitosa");
            body.put("code",found == null ? 404 : 200);
            body.put("status", found == null ? "NOT_FOUND" : "OK");
            body.put("data", found);

            return new ResponseEntity<>(body, found == null ? HttpStatus.BAD_REQUEST : HttpStatus.OK);
        }

        @Transactional(rollbackFor = {SQLException.class, Exception.class})
        public ResponseEntity<?> save(Pet pet) {
            Map<String, Object> body = new HashMap<>();
            Pet saved = null;
            try {
                saved = petRepository.save(pet);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
            }

            body.put("message", saved != null ? "Registro exitoso" :"Registro no completado" );
            body.put("code", saved != null ? 201 : 400);
            body.put("status", saved != null ? "OK" : "BAD_REQUEST");
            body.put("data", saved != null ? saved.getId() : null);

            return new ResponseEntity<>(body, saved != null ? HttpStatus.OK :HttpStatus.BAD_REQUEST );
        }

    @Transactional(rollbackFor = {SQLException.class, Exception.class})
    public ResponseEntity<?> update(Pet pet, long id) {
        Map<String, Object> body = new HashMap<>();
        Pet updated = null;

        if (petRepository.findById(id) != null) {
            pet.setId(id);
            try {
                updated = petRepository.save(pet);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
            }

            body.put("message", updated == null ? "Actualización no realizada" : "Actualización exitosa");
            body.put("code", updated != null ? 201 : 400);
            body.put("status", updated != null ? "OK" : "BAD_REQUEST");
            body.put("data", updated != null ? updated.getId() : null);

            return new ResponseEntity<>(body, updated == null ? HttpStatus.BAD_REQUEST : HttpStatus.OK);
        } else {
            body.put("message", "Registro no existente");
            body.put("code",404);
            body.put("status", "NOT_FOUND");
            body.put("data", null);

            return new ResponseEntity<>(body,HttpStatus.BAD_REQUEST);
        }
    }

    @Transactional(rollbackFor = {SQLException.class, Exception.class})
    public ResponseEntity<?> delete(long id) {
        Map<String, Object> body = new HashMap<>();
        HttpStatus status = null;

        if (petRepository.findById(id) != null) {
            try {
                petRepository.deleteById(id);

                body.put("message", "Registro no existente");
                body.put("code",200);
                body.put("status", "OK");
                status = HttpStatus.OK;


            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(e.getMessage());

                body.put("message","Error en la eliminación");
                body.put("code",400);
                body.put("status", "BAD_REQUEST");
                status = HttpStatus.BAD_REQUEST;


            }
        } else {
            body.put("message","Error el registro no existente");
            body.put("code",404);
            body.put("status", "NOT_FOUND");
            status = HttpStatus.BAD_REQUEST;


        }

        return new ResponseEntity<>(body, status);
    }
}
