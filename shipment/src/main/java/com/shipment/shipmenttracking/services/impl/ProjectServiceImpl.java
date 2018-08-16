package com.shipment.shipmenttracking.services.impl;

import com.shipment.shipmenttracking.dtos.ProjectDto;
import com.shipment.shipmenttracking.entities.ProjectEntity;
import com.shipment.shipmenttracking.helpers.ProjectMapper;
import com.shipment.shipmenttracking.repositories.ProjectRepository;
import com.shipment.shipmenttracking.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class ProjectServiceImpl implements ProjectService{

    @Autowired
    ProjectRepository projectRepository;

    @Override
    @Transactional
    public ProjectDto create(ProjectDto projectDto) throws DataAccessException {
        return null;
    }

    @Override
    public void update(ProjectDto projectDto) throws DataAccessException {

    }

    @Override
    public void delete(Integer id) throws DataAccessException {

    }

    @Override
    public ProjectDto findOneById(Integer id) throws DataAccessException {
        return null;
    }

    @Override
    public List<ProjectDto> findAll() throws DataAccessException {
        return null;
    }
}
