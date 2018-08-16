package com.shipment.shipmenttracking.helpers;

import com.shipment.shipmenttracking.dtos.ProjectDto;
import com.shipment.shipmenttracking.entities.ProjectEntity;
import com.shipment.shipmenttracking.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ProjectMapper {

    @Autowired
    ProjectRepository projectRepository;

    public static ProjectDto toDto(ProjectEntity projectEntity) {
        return null;
    }

    public static ProjectEntity toEntity(ProjectDto projectDto){
        ProjectEntity projectEntity = new ProjectEntity();
        projectEntity.setId(projectDto.getId());
        projectEntity.setProjectNumber(projectDto.getProjectNumber());
        projectEntity.setShipmentType(projectDto.getShipmentType());
        projectEntity.setShipmentDirection(projectDto.getShipmentDirection());
        projectEntity.setOriginId(projectDto.getOrigin().getId());
        projectEntity.setDestinationId(projectDto.getDestination().getId());
        projectEntity.setShipperId(projectDto.getShipper().getId());
        projectEntity.setConsigneeId(projectDto.getConsignee().getId());
        projectEntity.setCarrierId(projectDto.getCarrier().getId());
        projectEntity.setWeight(projectDto.getWeight());
        projectEntity.setIncoterms(projectDto.getIncoterms());
        projectEntity.setNotes(projectDto.getNotes());

        return projectEntity;
    }


}
