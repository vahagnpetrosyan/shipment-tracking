package com.shipment.shipmenttracking.services;

import com.shipment.shipmenttracking.dtos.OrganizationDto;
import com.shipment.shipmenttracking.helpers.OrganizationMapper;
import com.shipment.shipmenttracking.repositories.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

/**
 * Created by Vahagn.Petrosyan on 3/16/2019.
 */
@Service
public class OrganizationService {

    @Autowired
    OrganizationRepository organizationRepository;

    @Autowired
    OrganizationMapper organizationMapper;

    public Flux<OrganizationDto> getAll() {
        return organizationMapper.toDtoFlux(organizationRepository.findAll());
    }
}
