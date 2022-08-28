package com.jonsnow.projectmanagement.dao;

import com.jonsnow.projectmanagement.entities.Project;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;


@SpringBootTest
@RunWith(SpringRunner.class)
@SqlGroup({@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = {"classpath:schema.sql", "classpath:data.sql"}),  //these files are not necessary
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = {"classpath:drop.sql"})})
//these files are not necessary
public class ProjectRepositoryIntegrationTest {
    @Autowired
    ProjectRepository projectRepository;

    @Test
    public void ifNewProjectSaved_thenSuccess() {
        Project newProject = new Project("New Test Project", "Complete", "Test Description");


        projectRepository.save(newProject);

        assertEquals(9, projectRepository.findAll().size());
    }
}