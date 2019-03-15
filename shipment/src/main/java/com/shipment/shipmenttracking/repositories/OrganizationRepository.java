package com.shipment.shipmenttracking.repositories;

import com.shipment.shipmenttracking.entities.OrganizationEntity;
import org.springframework.dao.DataAccessException;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Repository
public interface OrganizationRepository extends R2dbcRepository<OrganizationEntity, Integer> {
    @Override
    <S extends OrganizationEntity> Mono<S> save(S entity);

    @Override
    Mono<OrganizationEntity> findById(Integer integer);

    @Override
    Flux<OrganizationEntity> findAll();

    @Override
    Mono<Void> delete(OrganizationEntity entity);
}