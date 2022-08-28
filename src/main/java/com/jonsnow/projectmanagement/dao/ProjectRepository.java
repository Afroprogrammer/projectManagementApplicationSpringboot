package com.jonsnow.projectmanagement.dao;

import com.jonsnow.projectmanagement.dto.ChartData;
import com.jonsnow.projectmanagement.entities.Project;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {
   @Override
    public List<Project>  findAll();

    @Query(nativeQuery=true, value="SELECT stage as label, COUNT(*) as points " +
            "FROM project " +
            "GROUP BY stage")

    public List <ChartData> getProjectStatus();
}
