package com.shipment.shipmenttracking.dtos;

import javax.validation.constraints.NotNull;

public class ProjectDto {
    private int id;
    private String projectNumber;
//    @NotNull
    private String shipmentType;
//    @NotNull
    private String shipmentDirection;
//    @NotNull
    private CountryDto origin;
//    @NotNull
    private CountryDto destination;
//    @NotNull
    private OrganizationDto shipper;
//    @NotNull
    private OrganizationDto consignee;
//    @NotNull
    private OrganizationDto carrier;
    private double weight;
//    @NotNull
    private String incoterms;
    private String notes;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProjectDto)) return false;

        ProjectDto that = (ProjectDto) o;

        if (id != that.id) return false;
        if (Double.compare(that.weight, weight) != 0) return false;
        if (projectNumber != null ? !projectNumber.equals(that.projectNumber) : that.projectNumber != null)
            return false;
        if (!shipmentType.equals(that.shipmentType)) return false;
        if (!shipmentDirection.equals(that.shipmentDirection)) return false;
        if (!origin.equals(that.origin)) return false;
        if (!destination.equals(that.destination)) return false;
        if (!shipper.equals(that.shipper)) return false;
        if (!consignee.equals(that.consignee)) return false;
        if (!carrier.equals(that.carrier)) return false;
        if (!incoterms.equals(that.incoterms)) return false;
        return notes != null ? notes.equals(that.notes) : that.notes == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (projectNumber != null ? projectNumber.hashCode() : 0);
        result = 31 * result + shipmentType.hashCode();
        result = 31 * result + shipmentDirection.hashCode();
        result = 31 * result + origin.hashCode();
        result = 31 * result + destination.hashCode();
        result = 31 * result + shipper.hashCode();
        result = 31 * result + consignee.hashCode();
        result = 31 * result + carrier.hashCode();
        temp = Double.doubleToLongBits(weight);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + incoterms.hashCode();
        result = 31 * result + (notes != null ? notes.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ProjectDto{" +
                "id=" + id +
                ", projectNumber='" + projectNumber + '\'' +
                ", shipmentType='" + shipmentType + '\'' +
                ", shipmentDirection='" + shipmentDirection + '\'' +
                ", origin=" + origin +
                ", destination=" + destination +
                ", shipper=" + shipper +
                ", consignee=" + consignee +
                ", carrier=" + carrier +
                ", weight=" + weight +
                ", incoterms='" + incoterms + '\'' +
                ", notes='" + notes + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProjectNumber() {
        return projectNumber;
    }

    public void setProjectNumber(String projectNumber) {
        this.projectNumber = projectNumber;
    }

    public String getShipmentType() {
        return shipmentType;
    }

    public void setShipmentType(String shipmentType) {
        this.shipmentType = shipmentType;
    }

    public String getShipmentDirection() {
        return shipmentDirection;
    }

    public void setShipmentDirection(String shipmentDirection) {
        this.shipmentDirection = shipmentDirection;
    }

    public CountryDto getOrigin() {
        return origin;
    }

    public void setOrigin(CountryDto origin) {
        this.origin = origin;
    }

    public CountryDto getDestination() {
        return destination;
    }

    public void setDestination(CountryDto destination) {
        this.destination = destination;
    }

    public OrganizationDto getShipper() {
        return shipper;
    }

    public void setShipper(OrganizationDto shipper) {
        this.shipper = shipper;
    }

    public OrganizationDto getConsignee() {
        return consignee;
    }

    public void setConsignee(OrganizationDto consignee) {
        this.consignee = consignee;
    }

    public OrganizationDto getCarrier() {
        return carrier;
    }

    public void setCarrier(OrganizationDto carrier) {
        this.carrier = carrier;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getIncoterms() {
        return incoterms;
    }

    public void setIncoterms(String incoterms) {
        this.incoterms = incoterms;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
