package com.superheros.ingrid.controllers;

import com.superheros.ingrid.entity.CityEntity;
import com.superheros.ingrid.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/city")
public class CityController {

    @Autowired
    CityService cityService;

    @GetMapping("path")
    public List<CityEntity> findAll(){
        return this.cityService.findAll();
    }

    @PostMapping("path")
    public CityEntity save(@RequestBody CityEntity city){
        return this.cityService.save(city);
    }
}
