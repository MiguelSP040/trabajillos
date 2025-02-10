package com.superheros.ingrid.services;

import com.superheros.ingrid.entity.SuperPowerEntity;
import com.superheros.ingrid.repository.SuperPowerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class SuperPowerService {

    @Autowired
    SuperPowerRepository superPowerRepository;

    public List<SuperPowerEntity> findAll() {
        return this.superPowerRepository.findAll();
    }

    public SuperPowerEntity findById(Integer id) {
        return this.superPowerRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "SuperPower not found"));
    }

    public SuperPowerEntity save(SuperPowerEntity superPowerEntity) {
        return this.superPowerRepository.save(superPowerEntity);
    }

    public SuperPowerEntity update(SuperPowerEntity superPowerEntity) {
        return this.superPowerRepository.save(superPowerEntity);
    }

    public void deleteById(Integer id) {
        if (!this.superPowerRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "SuperPower not found");
        }
        this.superPowerRepository.deleteById(id);
    }
}
