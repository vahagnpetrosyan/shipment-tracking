package com.shipment.shipmenttracking.services;

import com.shipment.shipmenttracking.dtos.ProjectDto;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface ProjectService {
    ProjectDto create(ProjectDto projectDto) throws DataAccessException;
    void update(ProjectDto projectDto) throws DataAccessException;
    void delete(Integer id) throws DataAccessException;
    ProjectDto findOneById(Integer id) throws DataAccessException;
    List<ProjectDto> findAll() throws DataAccessException;
}