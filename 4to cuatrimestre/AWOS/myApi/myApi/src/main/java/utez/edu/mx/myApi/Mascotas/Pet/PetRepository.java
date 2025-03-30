package utez.edu.mx.myApi.Mascotas.Pet;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {
    List<Pet> findAll();
    Pet findById(long id);
    Pet save(Pet pet);
    void deleteById(long id);
}
