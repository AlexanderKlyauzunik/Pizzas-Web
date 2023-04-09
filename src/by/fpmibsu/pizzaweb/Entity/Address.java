package src.by.fpmibsu.pizzaweb.Entity;

import java.util.Objects;

public class Address extends Entity{
    private String street;
    private Integer houseNumber;

    private Integer entrance;
    private String flatNumber;

    public Address() {}

    public Address(String street, Integer houseNumber, Integer entrance, String flatNumber) {
        this.street = street;
        this.houseNumber = houseNumber;
        this.entrance = entrance;
        this.flatNumber = flatNumber;
    }

    public Address(Long addressID, String street, Integer houseNumber, Integer entrance, String flatNumber) {
        super(addressID);
        this.street = street;
        this.houseNumber = houseNumber;
        this.entrance = entrance;
        this.flatNumber = flatNumber;
    }

    public Long getAddressID() {
        return this.getId();
    }

    public void setAddressID(Long addressID) {
        this.setId(addressID);
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

    public String getFlatNumber() {
        return this.flatNumber;
    }

    public void setFlatNumber(String flatNumber) {
        this.flatNumber = flatNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(street, address.street) && Objects.equals(houseNumber, address.houseNumber) && Objects.equals(entrance, address.entrance) && Objects.equals(flatNumber, address.flatNumber);
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", houseNumber=" + houseNumber +
                ", entrance=" + entrance +
                ", flatNumber=" + flatNumber +
                '}';
    }
}
