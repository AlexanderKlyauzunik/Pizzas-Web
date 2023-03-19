package src.by.fpmibsu.pizzaweb.entity;

import java.util.Objects;

public class Address {
    private Long addressID;
    private String street;
    private Integer houseNumber;
    private Integer entrance;
    private Integer flatNumber;

    public Address(Long addressID, String street, Integer houseNumber, Integer entrance, Integer flatNumber) {
        this.addressID = addressID;
        this.street = street;
        this.houseNumber = houseNumber;
        this.entrance = entrance;
        this.flatNumber = flatNumber;
    }

    public Long getAddressID() {
        return this.addressID;
    }

    public void setAddressID(Long addressID) {
        this.addressID = addressID;
    }

    public String getStreet() {
        return this.street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getHouseNumber() {
        return this.houseNumber;
    }

    public void setHouseNumber(Integer houseNumber) {
        this.houseNumber = houseNumber;
    }

    public Integer getEntrance() {
        return this.entrance;
    }

    public void setEntrance(Integer entrance) {
        this.entrance = entrance;
    }

    public Integer getFlatNumber() {
        return this.flatNumber;
    }

    public void setFlatNumber(Integer flatNumber) {
        this.flatNumber = flatNumber;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            Address address = (Address)o;
            return Objects.equals(this.addressID, address.addressID) && Objects.equals(this.street, address.street) && Objects.equals(this.houseNumber, address.houseNumber) && Objects.equals(this.entrance, address.entrance) && Objects.equals(this.flatNumber, address.flatNumber);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.addressID, this.street, this.houseNumber, this.entrance, this.flatNumber});
    }

    public String toString() {
        return "Address{addressID=" + this.addressID + ", street='" + this.street + "', houseNumber=" + this.houseNumber + ", entrance=" + this.entrance + ", flatNumber=" + this.flatNumber + "}";
    }
}
