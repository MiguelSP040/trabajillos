package utez.edu.mx.paqueteria.utils.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import utez.edu.mx.paqueteria.modules.user.User;
import utez.edu.mx.paqueteria.modules.user.UserRepository;
import java.util.Collections;

@Service
public class UseDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null){
            throw new UsernameNotFoundException("Usuario no encontrado: " +  username);
        }

        GrantedAuthority authority = new SimpleGrantedAuthority(user.getRol().getName());

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), Collections.singleton(authority));
    }
}
