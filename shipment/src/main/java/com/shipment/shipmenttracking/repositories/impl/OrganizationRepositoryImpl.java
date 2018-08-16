package com.shipment.shipmenttracking.repositories.impl;

import com.shipment.shipmenttracking.entities.OrganizationEntity;
import com.shipment.shipmenttracking.repositories.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;

//TODO more generic implementation
@SuppressWarnings("Duplicates")
@Repository
public class OrganizationRepositoryImpl implements OrganizationRepository {

    private static String CREATION_SQL_STMT = "INSERT INTO organizations " +
                                              "(name, registry_number, contact_phone, contact_email) " +
                                              "VALUES (:name, :registry_number, :contact_phone, :contact_email)";

    private static final String UPDATE_SQL_STMT = "UPDATE organizations SET %s = ? WHERE id = ?";
    private static final String DELETE_SQL_STMT = "DELETE FROM organizations WHERE id = ?";
    private static final String GET_ONE_SQL_STMT = "SELECT * from organizations WHERE id = ?";
    private static final String SELECT_ALL = "SELECT * FROM organizations";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public OrganizationEntity create(OrganizationEntity organizationEntity) throws DataAccessException {
        SqlParameterSource params = new BeanPropertySqlParameterSource(organizationEntity);
        KeyHolder keyHolder = new GeneratedKeyHolder();

        namedParameterJdbcTemplate.update(CREATION_SQL_STMT, params, keyHolder);
        organizationEntity.setId((Integer) keyHolder.getKeys().get("id"));
        return organizationEntity;
    }

    @Override
    public void update(OrganizationEntity organizationEntity) throws DataAccessException {
        updateName(organizationEntity);
        updateRegistryNumber(organizationEntity);
        updateContactPhone(organizationEntity);
        updateContactEmail(organizationEntity);
    }

    @Override
    public void delete(Integer id) throws DataAccessException {
        jdbcTemplate.update(DELETE_SQL_STMT, id);
    }

    @Override
    public OrganizationEntity findOneById(Integer id) throws DataAccessException {
        return jdbcTemplate.queryForObject(GET_ONE_SQL_STMT, new Object[]{id}, (rs, rownum) -> {
            OrganizationEntity organizationEntity = new OrganizationEntity();
            organizationEntity.setId(rs.getInt("id"));
            organizationEntity.setName(rs.getString("name"));
            organizationEntity.setRegistryNumber(rs.getString("registry_number"));
            organizationEntity.setContactPhone(rs.getString("contact_phone"));
            organizationEntity.setContactEmail(rs.getString("contact_email"));

            return organizationEntity;
        });
    }

    @Override
    public List<OrganizationEntity> findAll() throws DataAccessException {
        return jdbcTemplate.query(SELECT_ALL, (rs, rownum) -> {
            OrganizationEntity organizationEntity = new OrganizationEntity();
            organizationEntity.setId(rs.getInt("id"));
            organizationEntity.setName(rs.getString("name"));
            organizationEntity.setRegistryNumber(rs.getString("registry_number"));
            organizationEntity.setContactPhone(rs.getString("contact_phone"));
            organizationEntity.setContactEmail(rs.getString("contact_email"));

            return organizationEntity;
        });
    }

    private void updateName(OrganizationEntity organizationEntity) {
        jdbcTemplate.update(String.format(UPDATE_SQL_STMT, "name"),
                organizationEntity.getName(), organizationEntity.getId());
    }

    private void updateRegistryNumber(OrganizationEntity organizationEntity) {
        if(organizationEntity.getRegistryNumber() != null){
            jdbcTemplate.update(String.format(UPDATE_SQL_STMT, "registry_number"),
                    organizationEntity.getRegistryNumber(), organizationEntity.getId());
        }
    }

    private void updateContactPhone(OrganizationEntity organizationEntity) {
        if (organizationEntity.getContactPhone() != null){
            jdbcTemplate.update(String.format(UPDATE_SQL_STMT, "contact_phone"),
                    organizationEntity.getContactPhone(), organizationEntity.getId());
        }
    }

    private void updateContactEmail(OrganizationEntity organizationEntity) {
        if (organizationEntity.getContactEmail() != null){
            jdbcTemplate.update(String.format(UPDATE_SQL_STMT, "contact_email"),
                    organizationEntity.getContactEmail(), organizationEntity.getId());
        }
    }
}
