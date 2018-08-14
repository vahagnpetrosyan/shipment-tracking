package com.shipment.shipmenttracking.repositories.impl;

import com.shipment.shipmenttracking.entities.ProjectEntity;
import com.shipment.shipmenttracking.repositories.ProjectRepository;
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

//TODO more generic implene
@Repository
public class ProjectRepositoryImpl implements ProjectRepository{
    private static final String CREATION_SQL_STMT =
            "INSERT INTO projects (project_number, shipment_type, shipment_direction, origin_id, destination_id, " +
            "shipper_id, consignee_id, carrier_id, weight, incoterms, notes)" +
            " VALUES (:project_number, :shipment_type, :shipment_direction, :origin_id, :destination_id, " +
            ":shipper_id, :consignee_id, :carrier_id, :weight, :incoterms, :notes)";

    private static final String BULK_UPDATE_SQL_STMT = "UPDATE projects SET " +
            "shipment_type = ?, " +
            "shipment_direction = ?, " +
            "origin_id = ?, " +
            "destination_id = ?, " +
            "shipper_id = ?, " +
            "consignee_id = ?, " +
            "carrier_id = ?, " +
            "incoterms = ? WHERE id = ?";

    private static final String UPDATE_SQL_STMT = "UPDATE projects SET %s = ? WHERE id = ?";
    private static final String GET_ONE_SQL_STMT = "SELECT * from projects WHERE id = ?";
    private static final String SELECT_ALL = "SELECT * FROM projects";
    private static final String DELETE_SQL_STMT = "DELETE FROM projects WHERE id = ?";


    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    @Override
    public ProjectEntity create(ProjectEntity projectEntity) throws DataAccessException {
        SqlParameterSource fileParameters = new BeanPropertySqlParameterSource(projectEntity);
        KeyHolder keyHolder = new GeneratedKeyHolder();

        namedParameterJdbcTemplate.update(CREATION_SQL_STMT, fileParameters, keyHolder);
        projectEntity.setId((Integer) keyHolder.getKeys().get("id"));
        return projectEntity;
    }

    @Override
    public void update(ProjectEntity projectEntity) throws DataAccessException {

        jdbcTemplate.update(BULK_UPDATE_SQL_STMT, projectEntity.getShipmentType(),
                                                  projectEntity.getShipmentDirection(),
                                                  projectEntity.getOriginId(),
                                                  projectEntity.getDestinationId(),
                                                  projectEntity.getShipperId(),
                                                  projectEntity.getConsigneeId(),
                                                  projectEntity.getCarrierId(),
                                                  projectEntity.getIncoterms(),
                                                  projectEntity.getId());

        updateProjectNumber(projectEntity);
        updateProjectWeight(projectEntity);
        updateProjectNotes(projectEntity);
    }

    @Override
    public void delete(Integer id) throws DataAccessException {
        jdbcTemplate.update(DELETE_SQL_STMT, id);
    }

    @Override
    public ProjectEntity findOneById(Integer id) throws DataAccessException {
        return jdbcTemplate.queryForObject(GET_ONE_SQL_STMT, new Object[]{id}, (rs, rownum) -> {
            ProjectEntity result = new ProjectEntity();
            result.setId(rs.getInt("id"));
            result.setProjectNumber(rs.getString("project_number"));
            result.setShipmentType(rs.getString("shipment_type"));
            result.setShipmentDirection(rs.getString("shipment_direction"));
            result.setOriginId(rs.getInt("origin_id"));
            result.setDestinationId(rs.getInt("destination_id"));
            result.setShipperId(rs.getInt("shipper_id"));
            result.setConsigneeId(rs.getInt("consignee_id"));
            result.setCarrierId(rs.getInt("carrier_id"));
            result.setWeight(rs.getDouble("weight"));
            result.setIncoterms(rs.getString("incoterms"));
            result.setNotes(rs.getString("notes"));

            return result;
        });
    }

    @Override
    public List<ProjectEntity> findAll() throws DataAccessException {
          return jdbcTemplate.query(SELECT_ALL, (rs, rownum) -> {
              ProjectEntity result = new ProjectEntity();
              result.setId(rs.getInt("id"));
              result.setProjectNumber(rs.getString("project_number"));
              result.setShipmentType(rs.getString("shipment_type"));
              result.setShipmentDirection(rs.getString("shipment_direction"));
              result.setOriginId(rs.getInt("origin_id"));
              result.setDestinationId(rs.getInt("destination_id"));
              result.setShipperId(rs.getInt("shipper_id"));
              result.setConsigneeId(rs.getInt("consignee_id"));
              result.setCarrierId(rs.getInt("carrier_id"));
              result.setWeight(rs.getDouble("weight"));
              result.setIncoterms(rs.getString("incoterms"));
              result.setNotes(rs.getString("notes"));

              return result;
          });
    }

    private void updateProjectNumber(ProjectEntity projectEntity){
        if(projectEntity.getProjectNumber() != null){
            jdbcTemplate.update(String.format(UPDATE_SQL_STMT, "project_number"),
                    projectEntity.getProjectNumber(), projectEntity.getId());
        }
    }
    private void updateProjectWeight(ProjectEntity projectEntity){
        if(projectEntity.getWeight() != null){
            jdbcTemplate.update(String.format(UPDATE_SQL_STMT, "weight"), projectEntity.getWeight(), projectEntity.getId());
        }
    }
    private void updateProjectNotes(ProjectEntity projectEntity){
        if(projectEntity.getNotes() != null){
            jdbcTemplate.update(String.format(UPDATE_SQL_STMT, "notes"), projectEntity.getNotes(), projectEntity.getId());
        }
    }
}
