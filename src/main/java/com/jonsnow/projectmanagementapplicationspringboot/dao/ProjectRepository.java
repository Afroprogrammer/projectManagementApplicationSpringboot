package com.jonsnow.projectmanagementapplicationspringboot.dao;

import com.jonsnow.projectmanagementapplicationspringboot.dto.ChartData;
import com.jonsnow.projectmanagementapplicationspringboot.entities.Project;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProjectRepository extends CrudRepository<Project, Long> {
   @Override
    public List<Project>  findAll();

    @Query(nativeQuery=true, value="SELECT stage as label, COUNT(*) as points " +
            "FROM project " +
            "GROUP BY stage")

    public List <ChartData> getProjectStatus();
}
