package utez.edu.mx.myApi.Mascotas.Type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import utez.edu.mx.myApi.Mascotas.Pet.Pet;
import utez.edu.mx.myApi.Mascotas.Pet.PetRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TypeService {
    @Autowired
    private TypeRepository typeRepository;

    @Transactional(readOnly = true)
    public ResponseEntity<?> findAll() {
        Map<String, Object> body = new HashMap<>();
        List<Type> list = typeRepository.findAll();

        body.put("message", list.isEmpty() ? "Aún no hay registros" : "Operación exitosa");
        body.put("code",200);
        body.put("status", "OK");
        body.put("data", list);

        return new ResponseEntity<>(body, HttpStatus.OK);
    }
}
