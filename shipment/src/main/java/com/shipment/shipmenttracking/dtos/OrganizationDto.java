package com.shipment.shipmenttracking.dtos;

import javax.validation.constraints.NotNull;

public class OrganizationDto {
    @NotNull
    private int id;
    @NotNull
    private String name;
    private String registryNumber;
    private String contactPhone;
    private String contactEmail;

}
