package com.shipment.shipmenttracking.repositories;

import com.shipment.shipmenttracking.entities.ProjectEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface ProjectRepository extends R2dbcRepository<ProjectEntity, Integer> {

    Mono<ProjectEntity> save(ProjectEntity projectEntity);
    Mono<Void> delete(ProjectEntity projectEntity);
    Mono<ProjectEntity> findById(Integer id);
    Flux<ProjectEntity> findAll();
}
