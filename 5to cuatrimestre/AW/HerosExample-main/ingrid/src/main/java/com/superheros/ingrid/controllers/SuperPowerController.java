package com.superheros.ingrid.controllers;

import com.superheros.ingrid.entity.SuperPowerEntity;
import com.superheros.ingrid.services.SuperPowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/superpower")
public class SuperPowerController {

    @Autowired
    SuperPowerService superPowerService;

    @PostMapping("path")
    public SuperPowerEntity save(@RequestBody SuperPowerEntity entity) {
        return this.superPowerService.save(entity);
    }

    @GetMapping("path")
    public List<SuperPowerEntity> findAll() {
        return this.superPowerService.findAll();
    }
}
