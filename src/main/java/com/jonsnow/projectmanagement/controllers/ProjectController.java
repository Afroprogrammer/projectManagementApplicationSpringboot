package com.jonsnow.projectmanagement.controllers;

import com.jonsnow.projectmanagement.dao.EmployeeRepository;
import com.jonsnow.projectmanagement.dao.ProjectRepository;
import com.jonsnow.projectmanagement.entities.Employee;
import com.jonsnow.projectmanagement.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/projects")
public class ProjectController {
    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping
    public String displayProject(Model model) {
        List<Project> projects = projectRepository.findAll();
        model.addAttribute("projects", projects);
        return "projects/list-project";
    }
    @GetMapping("/new")
    public String displayProjectForm(Model model){
        Project project = new Project();
        List<Employee> employees = employeeRepository.findAll();
        model.addAttribute("allEmployees", employees);
        model.addAttribute("project", project);
        return "projects/new-project";
    }
    @PostMapping("/save")
    public String createProject(Project project, Model model){
//        Iterable<Employee> chosenEmployees = employeeRepository.findAllById(employees);
//        for(Employee emp: chosenEmployees){
//            emp.setProjects(project);
//        }
        projectRepository.save(project);
            return "redirect:/projects";
    }
}
