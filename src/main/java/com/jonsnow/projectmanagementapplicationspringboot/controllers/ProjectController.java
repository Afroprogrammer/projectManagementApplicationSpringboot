package com.jonsnow.projectmanagementapplicationspringboot.controllers;

import com.jonsnow.projectmanagementapplicationspringboot.dao.ProjectRepository;
import com.jonsnow.projectmanagementapplicationspringboot.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/projects")
public class ProjectController {
    @Autowired
    ProjectRepository projectRepository;
    @GetMapping("/new")
    public String displayProjectForm(Model model){
        Project project = new Project();
        model.addAttribute("project", project);
        return "projects/project";
    }
    @PostMapping("/save")
    public String createProject(Project project, Model model, RedirectAttributes attributes){

        projectRepository.save(project);

            return "redirect:/projects/new";
    }
}
