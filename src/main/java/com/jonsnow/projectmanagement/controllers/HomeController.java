package com.jonsnow.projectmanagement.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jonsnow.projectmanagement.dao.EmployeeRepository;
import com.jonsnow.projectmanagement.dao.ProjectRepository;
import com.jonsnow.projectmanagement.dto.ChartData;
import com.jonsnow.projectmanagement.dto.EmployeeProject;
import com.jonsnow.projectmanagement.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    @Value("${version}")
    private String ver;

    @GetMapping("/")
    public String displayHome(Model model) throws JsonProcessingException {
//        Map<String ,Object> map = new HashMap<>();
        model.addAttribute("versionNumber", ver);
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