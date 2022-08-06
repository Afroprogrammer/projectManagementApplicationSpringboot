package com.jonsnow.projectmanagementapplicationspringboot.controllers;

import com.jonsnow.projectmanagementapplicationspringboot.dao.EmployeeRepository;
import com.jonsnow.projectmanagementapplicationspringboot.dao.ProjectRepository;
import com.jonsnow.projectmanagementapplicationspringboot.entities.Employee;
import com.jonsnow.projectmanagementapplicationspringboot.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/")
    public String displayHome(Model model){
        List<Project> projects = projectRepository.findAll();
        model.addAttribute("projects", projects);

        List<Employee> employeeList = employeeRepository.findAll();
        model.addAttribute("employee", employeeList);
        return "main/home";
    }
}
