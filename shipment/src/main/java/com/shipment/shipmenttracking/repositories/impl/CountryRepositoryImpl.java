package com.shipment.shipmenttracking.repositories.impl;

import com.shipment.shipmenttracking.entities.CountryEntity;
import com.shipment.shipmenttracking.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CountryRepositoryImpl implements CountryRepository{

    private static final String SELECT_ALL = "SELECT * FROM countries";
    private static final String GET_ONE_SQL_STMT = "SELECT * from countries WHERE id = ?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;



    @Override
    public List<CountryEntity> findAll() throws DataAccessException {
        return jdbcTemplate.query(SELECT_ALL, (rs, rownum) -> {
            CountryEntity countryEntity = new CountryEntity();
            countryEntity.setId(rs.getInt("id"));
            countryEntity.setName(rs.getString("name"));
            countryEntity.setCode(rs.getString("code"));

            return countryEntity;
        });
    }

    @Override
    public CountryEntity findOneById(Integer id) throws DataAccessException {
        return jdbcTemplate.queryForObject(GET_ONE_SQL_STMT, new Object[]{id}, (rs, rownum) -> {
            CountryEntity countryEntity = new CountryEntity();
            countryEntity.setId(rs.getInt("id"));
            countryEntity.setName(rs.getString("name"));
            countryEntity.setCode(rs.getString("code"));

            return countryEntity;
        });
    }
}
