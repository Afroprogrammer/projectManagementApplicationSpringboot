package com.jonsnow.projectmanagementapplicationspringboot.controllers;

import com.jonsnow.projectmanagementapplicationspringboot.dao.EmployeeRepository;
import com.jonsnow.projectmanagementapplicationspringboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/new")
    public String displayEmployeeForm( Model model){
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "employee/employee";
    }

    @PostMapping("/save")
    public String displayEmployeeForm(Employee employee){
        employeeRepository.save(employee);
        return "redirect:/employee/new";
    }

}
