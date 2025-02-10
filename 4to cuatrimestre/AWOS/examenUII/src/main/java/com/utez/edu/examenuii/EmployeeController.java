package com.utez.edu.examenuii;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("")
    public ResponseEntity<?> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable long id){
        return employeeService.findById(id);
    }

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody Employee employee){
        return employeeService.save(employee);
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody Employee employee){
        return employeeService.update(employee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id){
        return employeeService.deleteById(id);
    }
}
