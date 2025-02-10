package com.superheros.ingrid.services;

import com.superheros.ingrid.entity.CityEntity;
import com.superheros.ingrid.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    @Autowired
    CityRepository cityRepository;

    public List<CityEntity> findAll(){
        return this.cityRepository.findAll();
    }

    public CityEntity save(CityEntity cityEntity){
        return this.cityRepository.save(cityEntity);
    }
}
