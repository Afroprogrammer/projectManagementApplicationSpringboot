package com.jonsnow.projectmanagement.service;

import com.jonsnow.projectmanagement.dao.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    //Using the @Autowired injection
//    @Autowired
//    EmployeeRepository employeeRepository;


    //constructor injection

    private EmployeeRepository empRepo;

    public EmployeeService(EmployeeRepository empRepo) {
        this.empRepo = empRepo;
    }

    //setter injection
//    @Autowired
//    public void setEmpRepo(EmployeeRepository empRepo) {
//        this.empRepo = empRepo;
//    }
}
