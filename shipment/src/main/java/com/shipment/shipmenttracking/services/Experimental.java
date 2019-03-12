package com.shipment.shipmenttracking.services;

import com.shipment.shipmenttracking.entities.ProjectEntity;
import com.shipment.shipmenttracking.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

/**
 * Created by Vahagn.Petrosyan on 3/12/2019.
 */
@Service
public class Experimental {
    @Autowired
    public ProjectRepository projectRepository;


    public Flux<ProjectEntity> getAll(){
        return this.projectRepository.findAll();
    }
}
