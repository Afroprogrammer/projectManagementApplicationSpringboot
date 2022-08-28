package com.jonsnow.projectmanagement.controllers;

import com.jonsnow.projectmanagement.dao.EmployeeRepository;
import com.jonsnow.projectmanagement.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    EmployeeRepository employeeRepository;
    @GetMapping
    public String displayEmployee( Model model){
        List<Employee> employeeList = employeeRepository.findAll();
        model.addAttribute("employees", employeeList);
        return "employee/list-employee";
    }
    @GetMapping("/new")
    public String displayEmployeeForm( Model model){
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "employee/new-employee";
    }

    @PostMapping("/save")
    public String displayEmployeeForm(Employee employee){
        employeeRepository.save(employee);
        return "redirect:/employees/new";
    }

}
