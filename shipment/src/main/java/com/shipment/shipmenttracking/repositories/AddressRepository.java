package com.shipment.shipmenttracking.repositories;

import com.shipment.shipmenttracking.entities.AddressEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.r2dbc.repository.query.Query;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface AddressRepository extends R2dbcRepository<AddressEntity, Integer> {
    @Override
    <S extends AddressEntity> Mono<S> save(S entity);

    @Override
    Mono<AddressEntity> findById(Integer integer);

    @Override
    Flux<AddressEntity> findAll();

    @Override
    Mono<Void> delete(AddressEntity entity);

    @Query("SELECT * FROM address WHERE organization_id = $1")
    Mono<AddressEntity> findByOrganizationId(Integer organizationId);
}
