package by.fpmibsu.pizzaweb.entity;

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
        return addressID;
    }

    public void setAddressID(Long addressID) {
        this.addressID = addressID;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(Integer houseNumber) {
        this.houseNumber = houseNumber;
    }

    public Integer getEntrance() {
        return entrance;
    }

    public void setEntrance(Integer entrance) {
        this.entrance = entrance;
    }

    public Integer getFlatNumber() {
        return flatNumber;
    }

    public void setFlatNumber(Integer flatNumber) {
        this.flatNumber = flatNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(addressID, address.addressID) && Objects.equals(street, address.street) && Objects.equals(houseNumber, address.houseNumber) && Objects.equals(entrance, address.entrance) && Objects.equals(flatNumber, address.flatNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(addressID, street, houseNumber, entrance, flatNumber);
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressID=" + addressID +
                ", street='" + street + '\'' +
                ", houseNumber=" + houseNumber +
                ", entrance=" + entrance +
                ", flatNumber=" + flatNumber +
                '}';
    }
}