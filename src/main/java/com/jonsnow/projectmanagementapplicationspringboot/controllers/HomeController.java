package com.jonsnow.projectmanagementapplicationspringboot.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jonsnow.projectmanagementapplicationspringboot.dao.EmployeeRepository;
import com.jonsnow.projectmanagementapplicationspringboot.dao.ProjectRepository;
import com.jonsnow.projectmanagementapplicationspringboot.dto.ChartData;
import com.jonsnow.projectmanagementapplicationspringboot.dto.EmployeeProject;
import com.jonsnow.projectmanagementapplicationspringboot.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {
    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/")
    public String displayHome(Model model) throws JsonProcessingException {
        Map<String ,Object> map = new HashMap<>();
        List<Project> projects = projectRepository.findAll();

        List<ChartData> projectData = projectRepository.getProjectStatus();

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(projectData);
        model.addAttribute("projectStatus", jsonString);

        List<EmployeeProject> employeeListProjectCount = employeeRepository.employeeProjects();
        model.addAttribute("projects", projects);
        model.addAttribute("employeeProjectCount", employeeListProjectCount);
        return "main/home";
    }

    @GetMapping("/joe")
    public List<ChartData> displayChat(){
        return projectRepository.getProjectStatus();

    }


}