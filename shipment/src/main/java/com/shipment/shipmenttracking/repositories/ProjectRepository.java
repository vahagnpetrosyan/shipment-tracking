package com.shipment.shipmenttracking.repositories;

import com.shipment.shipmenttracking.entities.ProjectEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface ProjectRepository extends R2dbcRepository<ProjectEntity, Integer> {
    @Override
    <S extends ProjectEntity> Mono<S> save(S entity);
    @Override
    Mono<Void> delete(ProjectEntity projectEntity);
    @Override
    Mono<ProjectEntity> findById(Integer id);
    @Override
    Flux<ProjectEntity> findAll();
}
