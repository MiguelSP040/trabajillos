package com.utez.edu.examenuii;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional(readOnly = true)
    public ResponseEntity<?> findAll() {
        Map<String, Object> body = new HashMap<>();
        List<Employee> list = employeeRepository.findAll();

        body.put("message", list.isEmpty() ? "Aún no hay registros" : "Operación existosa");
        body.put("status", 200);
        body.put("data", list);
        return new ResponseEntity<>(body, HttpStatus.OK);
    }

    @Transactional(readOnly = true)
    public ResponseEntity<?> findById(long id) {
        Map<String, Object> body = new HashMap<>();
        Employee found = employeeRepository.findById(id);

        body.put("message", found == null ? "No existe registro del ID" : "Operación existosa");
        body.put("status", found == null ? 400 : 200);
        body.put("data", found);
        return new ResponseEntity<>(body, found == null ? HttpStatus.BAD_REQUEST : HttpStatus.OK);
    }

    @Transactional(rollbackFor = {SQLException.class, Exception.class})
    public ResponseEntity<?> save(Employee employee){
        Map<String, Object> body = new HashMap<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm", new Locale("es-MX"));
        Date currentDate = new Date();
        Employee saved = null;
        try {
            employee.setRegisteredOn(dateFormat.format(currentDate));
            employee.setStatus(true);
            saved = employeeRepository.save(employee);
        } catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        body.put("message", saved != null ? "Registro realizado exitosamente" : "Error");
        body.put("status", saved != null ? 200 : 400);
        return new ResponseEntity<>(body, saved != null ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }


    @Transactional(rollbackFor = {SQLException.class, Exception.class})
    public ResponseEntity<?> update(Employee employee) {
        Map<String, Object> body = new HashMap<>();
        Employee found = employeeRepository.findById(employee.getId());;
        if (found != null) {
            employee.setLastname(found.getLastname());
            employee.setStatus(found.isStatus());
            employee.setRegisteredOn(found.getRegisteredOn());
            found = employeeRepository.save(employee);
            body.put("message", found == null ? "Aún no hay registros" : "Operación existosa");
            body.put("status", found == null ? 400 : 200);
            body.put("data", found);
            return new ResponseEntity<>(body, HttpStatus.OK);
        } else {
            body.put("message", "El registro no existe :(");
            body.put("status", 404);
            return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
        }
    }

    @Transactional(rollbackFor = {SQLException.class, Exception.class})
    public ResponseEntity<?> deleteById(long id) {
        Map<String, Object> body = new HashMap<>();
        if (employeeRepository.findById(id) != null) {
            try {
                employeeRepository.deleteById(id);
                body.put("message", "Empleado eliminado :D");
                body.put("status", 200);
                return new ResponseEntity<>(body, HttpStatus.OK);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
                body.put("message", "Error al eliminar usuario *_/*");
                body.put("status", 400);
                return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
            }
        } else {
            body.put("message", "El registro no existe :(");
            body.put("status", 404);
            return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
        }
    }
}
