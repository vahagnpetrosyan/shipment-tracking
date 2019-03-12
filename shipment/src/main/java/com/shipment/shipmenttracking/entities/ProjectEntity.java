package com.shipment.shipmenttracking.entities;

import org.springframework.data.annotation.Id;


public class ProjectEntity {
    @Id
    private Integer id;
    private String projectNumber;
    private String shipmentType;
    private String shipmentDirection;
    private Integer originId;
    private Integer destinationId;
    private Integer shipperId;
    private Integer consigneeId;
    private Integer carrierId;
    private Double weight;
    private String incoterms;
    private String notes;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProjectEntity)) return false;

        ProjectEntity that = (ProjectEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (projectNumber != null ? !projectNumber.equals(that.projectNumber) : that.projectNumber != null)
            return false;
        if (shipmentDirection != null ? !shipmentDirection.equals(that.shipmentDirection) : that.shipmentDirection != null)
            return false;
        if (!originId.equals(that.originId)) return false;
        if (!destinationId.equals(that.destinationId)) return false;
        if (!shipperId.equals(that.shipperId)) return false;
        if (!consigneeId.equals(that.consigneeId)) return false;
        if (!carrierId.equals(that.carrierId)) return false;
        if (weight != null ? !weight.equals(that.weight) : that.weight != null) return false;
        return incoterms != null ? incoterms.equals(that.incoterms) : that.incoterms == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (projectNumber != null ? projectNumber.hashCode() : 0);
        result = 31 * result + (shipmentDirection != null ? shipmentDirection.hashCode() : 0);
        result = 31 * result + originId.hashCode();
        result = 31 * result + destinationId.hashCode();
        result = 31 * result + shipperId.hashCode();
        result = 31 * result + consigneeId.hashCode();
        result = 31 * result + carrierId.hashCode();
        result = 31 * result + (weight != null ? weight.hashCode() : 0);
        result = 31 * result + (incoterms != null ? incoterms.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ProjectEntity{" +
                "id=" + id +
                ", projectNumber='" + projectNumber + '\'' +
                ", shipmentDirection='" + shipmentDirection + '\'' +
                ", originId=" + originId +
                ", destinationId=" + destinationId +
                ", shipperId=" + shipperId +
                ", consigneeId=" + consigneeId +
                ", carrierId=" + carrierId +
                ", weight=" + weight +
                ", incoterms='" + incoterms + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProjectNumber() {
        return projectNumber;
    }

    public void setProjectNumber(String projectNumber) {
        this.projectNumber = projectNumber;
    }

    public String getShipmentDirection() {
        return shipmentDirection;
    }

    public void setShipmentDirection(String shipmentDirection) {
        this.shipmentDirection = shipmentDirection;
    }

    public Integer getOriginId() {
        return originId;
    }

    public void setOriginId(Integer originId) {
        this.originId = originId;
    }

    public Integer getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(Integer destinationId) {
        this.destinationId = destinationId;
    }

    public Integer getShipperId() {
        return shipperId;
    }

    public void setShipperId(Integer shipperId) {
        this.shipperId = shipperId;
    }

    public Integer getConsigneeId() {
        return consigneeId;
    }

    public void setConsigneeId(Integer consigneeId) {
        this.consigneeId = consigneeId;
    }

    public Integer getCarrierId() {
        return carrierId;
    }

    public void setCarrierId(Integer carrierId) {
        this.carrierId = carrierId;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
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

    public String getShipmentType() {
        return shipmentType;
    }

    public void setShipmentType(String shipmentType) {
        this.shipmentType = shipmentType;
    }
}
