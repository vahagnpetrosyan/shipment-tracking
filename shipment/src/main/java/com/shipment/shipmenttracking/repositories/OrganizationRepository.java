package com.shipment.shipmenttracking.repositories;

import com.shipment.shipmenttracking.entities.OrganizationEntity;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface OrganizationRepository {
    OrganizationEntity create(OrganizationEntity organizationEntity) throws DataAccessException;
    void update(OrganizationEntity organizationEntity) throws DataAccessException;
    void delete(Integer id) throws DataAccessException;
    OrganizationEntity findOneById(Integer id) throws DataAccessException;
    List<OrganizationEntity> findAll() throws DataAccessException;
}