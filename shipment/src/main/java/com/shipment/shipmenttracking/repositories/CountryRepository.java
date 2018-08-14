package com.shipment.shipmenttracking.repositories;

import com.shipment.shipmenttracking.entities.CountryEntity;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface CountryRepository {
    List<CountryEntity> findAll() throws DataAccessException;
    CountryEntity findOneById(Integer id) throws DataAccessException;
}
