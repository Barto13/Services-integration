package com.sri.s23432.sri02.repo;

import com.sri.s23432.sri02.model.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    List<Employee> findAll();
}
