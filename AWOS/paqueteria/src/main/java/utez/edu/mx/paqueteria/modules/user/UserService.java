package utez.edu.mx.paqueteria.modules.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import utez.edu.mx.paqueteria.modules.user.DTO.UserDTO;
import utez.edu.mx.paqueteria.modules.user.DTO.UserPacketDTO;
import utez.edu.mx.paqueteria.utils.CustomResponseEntity;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CustomResponseEntity customResponseEntity;

    public UserDTO transformUserDTO(User u) {
        return new UserDTO(
                u.getId(),
                u.getName(),
                u.getSurname(),
                u.getLastname(),
                u.getEmail(),
                u.getUsername(),
                u.getRol()
        );
    }

    public UserPacketDTO transformUserToDTOForPacket(User u) {
        return new UserPacketDTO(
                u.getId(),
                u.getName(),
                u.getSurname(),
                u.getLastname(),
                u.getEmail()
        );
    }

    @Transactional(readOnly = true)
    public ResponseEntity<?> findAll(){
        List<UserDTO> list = new ArrayList<>();
        String message = "";
        if (userRepository.findAll().isEmpty()) {
            message = "No users found";
        }else {
            message = "Operacion exitosa";
            for (User u: userRepository.findAll()) {
                list.add(transformUserDTO(u));
            }
        }
        return customResponseEntity.getOkResponse(message, "OK", 200, list);
    }

    @Transactional(readOnly = true)
    public ResponseEntity<?> findByIdRol(int idRol) {
        List<UserDTO> list = new ArrayList<>();
        String message = "";
        if (userRepository.findAllByIdRol(idRol).isEmpty()){
            message = "No users found";
        }else {
            message = "Operacion exitosa";
            for (User u: userRepository.findAllByIdRol(idRol)){
                list.add(transformUserDTO(u));
            }
        }
        return customResponseEntity.getOkResponse(message, "OK", 200, list);
    }

    @Transactional(readOnly = true)
    public ResponseEntity<?> findById(long idUser) {
        UserDTO dto = null;
        User found = userRepository.findById(idUser);
        String message = "";
        if (found == null) {
            return customResponseEntity.get404Response();
        }else {
            message = "Operacion exitosa";
            dto = transformUserDTO(found);

            return customResponseEntity.getOkResponse(message, "OK", 200, dto);
        }
    }

    @Transactional(rollbackFor = {SQLException.class, Exception.class})
    public ResponseEntity<?> save(User user) {
        try{
            userRepository.save(user);
            return customResponseEntity.getOkResponse(
                    "Registro exitoso",
                    "CREATED",
                    201,
                    null
            );
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return customResponseEntity.get400Response();
        }
    }

    @Transactional(rollbackFor = {SQLException.class, Exception.class})
    public ResponseEntity<?> update(User user) {
        User found = userRepository.findById(user.getId());
        if (found == null) {
            return customResponseEntity.get404Response();
        }else {
            try {
                user.setPassword(found.getPassword());
                userRepository.save(user);
                return customResponseEntity.getOkResponse(
                        "Actualización exitosa",
                        "OK",
                        200,
                        null
                );
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
                return customResponseEntity.get400Response();
            }
        }
    }

    @Transactional(rollbackFor = {SQLException.class, Exception.class})
    public ResponseEntity<?> deleteById(User user) {
        if (userRepository.findById(user.getId()) == null) {
            return customResponseEntity.get404Response();
        }else {
            try {
                userRepository.deleteById(user.getId());
                return customResponseEntity.getOkResponse(
                        "Eliminación exitosa",
                        "OK",
                        200,
                        null
                );
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
                return customResponseEntity.get400Response();
            }
        }
    }


}
