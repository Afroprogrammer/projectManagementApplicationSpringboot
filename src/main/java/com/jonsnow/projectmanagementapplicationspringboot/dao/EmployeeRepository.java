package com.jonsnow.projectmanagementapplicationspringboot.dao;

import com.jonsnow.projectmanagementapplicationspringboot.entities.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
     public List<Employee> findAll();
}
