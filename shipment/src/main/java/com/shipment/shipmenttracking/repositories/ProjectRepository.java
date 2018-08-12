package com.shipment.shipmenttracking.repositories;

import com.shipment.shipmenttracking.entities.ProjectEntity;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface ProjectRepository {

    ProjectEntity create(ProjectEntity projectEntity) throws DataAccessException;
    void update(ProjectEntity projectEntity) throws DataAccessException;
    void delete(Integer id) throws DataAccessException;
    ProjectEntity findOneById(Integer id) throws DataAccessException;
    List<ProjectEntity> findAll() throws DataAccessException;
}
