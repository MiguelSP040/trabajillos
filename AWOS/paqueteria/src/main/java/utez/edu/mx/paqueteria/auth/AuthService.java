package utez.edu.mx.paqueteria.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import utez.edu.mx.paqueteria.auth.DTO.AuthLoginDTO;
import utez.edu.mx.paqueteria.modules.user.User;
import utez.edu.mx.paqueteria.modules.user.UserDetailsImpl;
import utez.edu.mx.paqueteria.modules.user.UserRepository;
import utez.edu.mx.paqueteria.utils.CustomResponseEntity;
import utez.edu.mx.paqueteria.utils.security.JWTUtil;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CustomResponseEntity customResponseEntity;

    @Autowired
    private JWTUtil jwtUtil;

    @Transactional(readOnly = true)
    public ResponseEntity<?> login(AuthLoginDTO authLoginDTO){
        User found = userRepository.findByPasswordAndEmailOrUsername(
                authLoginDTO.getPassword(),
                authLoginDTO.getUser()
        );
        if (found == null){
            return customResponseEntity.get404Response();
        } else {
            try {
                UserDetails userDetails = new UserDetailsImpl(found);
                return customResponseEntity.getOkResponse(
                        "Inicio de sesión exitoso",
                        "OK",
                        200,
                        jwtUtil.generateToken(userDetails)
                );
            } catch (Exception e){
                System.out.println(e.getMessage());
                e.printStackTrace();
                return customResponseEntity.get400Response();
            }
        }
    }
}
