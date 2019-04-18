package com.shipment.shipmenttracking.repositories;

import com.shipment.shipmenttracking.entities.CountryEntity;
import org.springframework.dao.DataAccessException;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Repository
public interface CountryRepository extends R2dbcRepository<CountryEntity, Integer> {

    @Override
    <S extends CountryEntity> Mono<S> save(S entity);

    @Override
    Mono<CountryEntity> findById(Integer integer);

    @Override
    Flux<CountryEntity> findAll();

    @Override
    Mono<Void> delete(CountryEntity entity);
}
