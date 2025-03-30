package utez.edu.mx.myApi.Mascotas.Owner;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> {
    List<Owner> findAll();
    Owner findById(long id);
    Owner save(Owner owner);
    void deleteById(long id);
}
