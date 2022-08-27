package com.jonsnow.projectmanagementapplicationspringboot;

import com.jonsnow.projectmanagementapplicationspringboot.dao.EmployeeRepository;
import com.jonsnow.projectmanagementapplicationspringboot.dao.ProjectRepository;
import com.jonsnow.projectmanagementapplicationspringboot.entities.Employee;
import com.jonsnow.projectmanagementapplicationspringboot.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class ProjectManagementApplicationSpringbootApplication {
    @Autowired
    EmployeeRepository empRepo;

    @Autowired
    ProjectRepository projRepo;
    public static void main(String[] args) {
        SpringApplication.run(ProjectManagementApplicationSpringbootApplication.class, args);
    }

}
