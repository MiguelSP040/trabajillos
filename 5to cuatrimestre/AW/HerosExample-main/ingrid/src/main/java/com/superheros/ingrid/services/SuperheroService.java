package com.superheros.ingrid.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.superheros.ingrid.entity.SuperheroEntity;
import com.superheros.ingrid.repository.SuperheroRepository;

@Service
public class SuperheroService {

    private final SuperheroRepository superheroRepository;

    @Autowired
    public SuperheroService(SuperheroRepository superheroRepository) {
        this.superheroRepository = superheroRepository;
    }

    public List<SuperheroEntity> findAll() {
        return superheroRepository.findAll();
    }

    public Optional<SuperheroEntity> findById(Long id) {
        return superheroRepository.findById(id);
                //.orElseThrow(() -> new RuntimeException("Superhero not found with ID: " + id));
    }
    public SuperheroEntity findByName(String name) {
        return superheroRepository.findByName(name)
        .orElseThrow(() -> new RuntimeException("Superhero not found with name: " + name));     
    }

    public SuperheroEntity save(SuperheroEntity superhero) {
        return superheroRepository.save(superhero);
    }

    public void deleteById(Long id) {
        if (!superheroRepository.existsById(id)) {
            throw new RuntimeException("Superhero not found with ID: " + id);
        }
        superheroRepository.deleteById(id);
    }
}
