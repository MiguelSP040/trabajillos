package com.utez.edu.examenuii;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findAll();
    Employee findById(long id);
    Employee save(Employee employee);
    void deleteById(long id);
}
