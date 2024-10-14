package utez.edu.mx.paqueteria.modules.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    //Tarer todos los ususarios
    List<User> findAll();

    //Traer todos los u por rol
    @Query(value = "SELECT * FROM user WHERE id_rol = :idRol", nativeQuery = true)
    List<User> findAllByIdRol(@Param("idRol") int idRol);

    //Traer un u por id
    User findById(long idUser);

    //Guardar/Actualizar un u
    User save(User user);

    //Eliminar usuario
    @Modifying
    @Query(value = "DELETE * FROM user WHERE id = :idUser", nativeQuery = true)
    void deleteById(@Param("idUser") Long idUser);
}
