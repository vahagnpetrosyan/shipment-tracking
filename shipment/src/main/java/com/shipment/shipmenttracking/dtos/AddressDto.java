package com.shipment.shipmenttracking.dtos;

import com.shipment.shipmenttracking.entities.AddressEntity;

public class AddressDto {
    private int id;
    private int organizationId;
    private int countryId;
    private String street;
    private String city;
    private String zipcode;

    public AddressDto(AddressEntity addressEntity){
        this.id = addressEntity.getId();
        this.organizationId = addressEntity.getOrganizationId();
        this.countryId = addressEntity.getCountryId();
        this.street = addressEntity.getStreet();
        this.city = addressEntity.getCity();
        this.zipcode = addressEntity.getZipcode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AddressDto)) return false;

        AddressDto that = (AddressDto) o;

        if (id != that.id) return false;
        if (organizationId != that.organizationId) return false;
        if (countryId != that.countryId) return false;
        if (street != null ? !street.equals(that.street) : that.street != null) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        return zipcode != null ? zipcode.equals(that.zipcode) : that.zipcode == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + organizationId;
        result = 31 * result + countryId;
        result = 31 * result + (street != null ? street.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (zipcode != null ? zipcode.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AddressDto{" +
                "id=" + id +
                ", organizationId=" + organizationId +
                ", countryId=" + countryId +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", zipcode='" + zipcode + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(int organizationId) {
        this.organizationId = organizationId;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
}
