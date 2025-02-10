package com.superheros.ingrid.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.superheros.ingrid.entity.SuperheroEntity;

@Repository
public interface SuperheroRepository extends JpaRepository<SuperheroEntity, Long> {
    // Métodos personalizados, si los necesitas
     public Optional<SuperheroEntity> findByName(String name);
}
