package com.shipment.shipmenttracking.entities;

public class OrganizationEntity {
    private Integer id;
    private String name;
    private String registryNumber;
    private String contactPhone;
    private String contactEmail;

    @Override
    public String toString() {
        return "OrganizationEntity{" +
                "name='" + name + '\'' +
                ", registryNumber='" + registryNumber + '\'' +
                ", contactPhone='" + contactPhone + '\'' +
                ", contactEmail='" + contactEmail + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrganizationEntity)) return false;

        OrganizationEntity that = (OrganizationEntity) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        if (!getName().equals(that.getName())) return false;
        if (getRegistryNumber() != null ? !getRegistryNumber().equals(that.getRegistryNumber()) : that.getRegistryNumber() != null)
            return false;
        if (getContactPhone() != null ? !getContactPhone().equals(that.getContactPhone()) : that.getContactPhone() != null)
            return false;
        return getContactEmail() != null ? getContactEmail().equals(that.getContactEmail()) : that.getContactEmail() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + getName().hashCode();
        result = 31 * result + (getRegistryNumber() != null ? getRegistryNumber().hashCode() : 0);
        result = 31 * result + (getContactPhone() != null ? getContactPhone().hashCode() : 0);
        result = 31 * result + (getContactEmail() != null ? getContactEmail().hashCode() : 0);
        return result;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
}
