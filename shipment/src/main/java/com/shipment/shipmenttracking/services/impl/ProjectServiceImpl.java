package com.shipment.shipmenttracking.services.impl;

import com.shipment.shipmenttracking.dtos.CountryDto;
import com.shipment.shipmenttracking.dtos.OrganizationDto;
import com.shipment.shipmenttracking.dtos.ProjectDto;
import com.shipment.shipmenttracking.entities.CountryEntity;
import com.shipment.shipmenttracking.entities.ProjectEntity;
import com.shipment.shipmenttracking.helpers.ProjectMapper;
import com.shipment.shipmenttracking.repositories.AddressRepository;
import com.shipment.shipmenttracking.repositories.CountryRepository;
import com.shipment.shipmenttracking.repositories.OrganizationRepository;
import com.shipment.shipmenttracking.repositories.ProjectRepository;
import com.shipment.shipmenttracking.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class ProjectServiceImpl implements ProjectService{

    @Autowired
    ProjectRepository projectRepository;
    @Autowired
    OrganizationRepository organizationRepository;
    @Autowired
    AddressRepository addressRepository;
    @Autowired
    CountryRepository countryRepository;

    @Override
    @Transactional
    public ProjectDto create(ProjectDto projectDto) throws DataAccessException {
        ProjectEntity resultProjEntity = projectRepository.create(ProjectMapper.toEntity(projectDto));
        CountryDto origin = projectDto.getOrigin();
        CountryDto destination = projectDto.getDestination();
        OrganizationDto shipper = projectDto.getShipper();
        OrganizationDto consignee = projectDto.getConsignee();
        OrganizationDto carrier = projectDto.getCarrier();

        ProjectDto resultDto = new ProjectDto();
        resultDto.setId(resultProjEntity.getId());
        resultDto
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
