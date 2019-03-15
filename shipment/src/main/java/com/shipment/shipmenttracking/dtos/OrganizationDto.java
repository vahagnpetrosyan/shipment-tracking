package com.shipment.shipmenttracking.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class OrganizationDto {
    private int id;
//    @NotNull
    private String name;
    private String registryNumber;
    private String contactPhone;
//    @Email
    private String contactEmail;
//    @NotNull
    private AddressDto addressDto;
//    @NotNull
    private CountryDto countryDto;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrganizationDto)) return false;

        OrganizationDto that = (OrganizationDto) o;

        if (id != that.id) return false;
        if (!name.equals(that.name)) return false;
        if (registryNumber != null ? !registryNumber.equals(that.registryNumber) : that.registryNumber != null)
            return false;
        if (contactPhone != null ? !contactPhone.equals(that.contactPhone) : that.contactPhone != null) return false;
        if (contactEmail != null ? !contactEmail.equals(that.contactEmail) : that.contactEmail != null) return false;
        if (!addressDto.equals(that.addressDto)) return false;
        return countryDto.equals(that.countryDto);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + name.hashCode();
        result = 31 * result + (registryNumber != null ? registryNumber.hashCode() : 0);
        result = 31 * result + (contactPhone != null ? contactPhone.hashCode() : 0);
        result = 31 * result + (contactEmail != null ? contactEmail.hashCode() : 0);
        result = 31 * result + addressDto.hashCode();
        result = 31 * result + countryDto.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "OrganizationDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", registryNumber='" + registryNumber + '\'' +
                ", contactPhone='" + contactPhone + '\'' +
                ", contactEmail='" + contactEmail + '\'' +
                ", addressDto=" + addressDto +
                ", countryDto=" + countryDto +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegistryNumber() {
        return registryNumber;
    }

    public void setRegistryNumber(String registryNumber) {
        this.registryNumber = registryNumber;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public AddressDto getAddressDto() {
        return addressDto;
    }

    public void setAddressDto(AddressDto addressDto) {
        this.addressDto = addressDto;
    }

    public CountryDto getCountryDto() {
        return countryDto;
    }

    public void setCountryDto(CountryDto countryDto) {
        this.countryDto = countryDto;
    }
}
