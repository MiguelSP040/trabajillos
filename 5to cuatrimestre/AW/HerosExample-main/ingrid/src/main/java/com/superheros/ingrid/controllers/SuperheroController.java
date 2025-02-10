package com.superheros.ingrid.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.superheros.ingrid.entity.SuperheroEntity;
import com.superheros.ingrid.services.SuperheroService;

@RestController
@RequestMapping("/api/superheroes")
public class SuperheroController {

    /*
    @RequestMapping(path = "requestMapping", method = RequestMethod.GET)
    public String requestMappingGet() {
        return "Hola, desde RequestMapping Get";
    }

    @RequestMapping(path = "requestMapping", method = RequestMethod.POST)
    public String requestMethodName() {
        return "Hola, desde Request Mapping POST";
    }

    @GetMapping("mapping")
    public String getMappingByArrow() {
        return "Hola";
    }

    @GetMapping("requestParam")
    public String getRequestParamGet(@RequestParam String param) {
        return "Hola desde RequestParam" + param;
    }

    @PutMapping("requestParam")
    public String getRequestParamPost(@RequestParam String nombre) {
        return "Hola desde RequestParam POST" + nombre;
    }

    @GetMapping("path/{id}")
    public String pathVaribleGet(@PathVariable int id) {
        return "El ID es: " + id;
    }

    @DeleteMapping("path/{id}")
    public String pathVariablePut(@PathVariable int id) {
        return "El ID es: " + id;
    }

    @PostMapping("path/{id}")
    public String postMethodName(@PathVariable int id, @RequestParam String name) {

        return "Hola " + name + " Tu identeificador es: " + id;
    }

    @PostMapping("requestBody")
    public SuperheroEntity requestBodyPost(@RequestBody SuperheroEntity hero) {
        System.out.println("Nombre: " + hero.getName());
        System.out.println("Nombre real: " + hero.getRealName());
        System.out.println("Nivel de poder: " + hero.getPower());
        return hero;
    }

    @GetMapping("error")
    public String getMethodName(@RequestParam String ISBN){
        Double formatedISBN = 0.0;

        try {
            formatedISBN = Double.parseDouble(ISBN);
            return "El ISBN es: " + formatedISBN;
        } catch (NumberFormatException e) {
            throw new ResponseStatusException(HttpStatus.I_AM_A_TEAPOT, "El ISBN no es valido");
        }
    }*/

    private final SuperheroService superheroService;

    @Autowired
    public SuperheroController(SuperheroService superheroService) {
        this.superheroService = superheroService;
    }

    @GetMapping
    public List<SuperheroEntity> getAllSuperheroes() {
        return superheroService.findAll();
    }
    /*
    @GetMapping("/{id}")
    public SuperheroEntity getSuperheroById(@PathVariable Long id) {
        return superheroService.findById(id);
    }
    */

    @PostMapping
    public SuperheroEntity createSuperhero(@RequestBody  SuperheroEntity superhero) {
        return superheroService.save(superhero);
    }

    /*@PutMapping("/{id}")
    public SuperheroEntity updateSuperhero(@PathVariable Long id, @RequestBody  SuperheroEntity superhero) {
        superhero.setId(id); 
        return superheroService.save(superhero);
    }*/

    @DeleteMapping("/{id}")
    public String deleteSuperhero(@PathVariable Long id) {
        Optional<SuperheroEntity> superheroOptional = superheroService.findById(id);
        if (!superheroOptional.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Superhero not found with ID: " + id);
        }
        superheroService.deleteById(id);
        return "Se eliminó";
    }
}