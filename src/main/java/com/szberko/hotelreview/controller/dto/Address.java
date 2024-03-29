package com.szberko.hotelreview.controller.dto;

import io.swagger.annotations.ApiModelProperty;

import javax.annotation.Nonnull;
import java.util.Objects;

public class Address {

    @ApiModelProperty(notes = "City of your hotel", example = "Novi Sad", required = true)
    @Nonnull
    private final String city;
    @ApiModelProperty(notes = "Country of your hotel", example = "Serbia", required = true)
    @Nonnull
    private final String country;
    @ApiModelProperty(notes = "Street of your hotel", example = "Miroslava Antica 18", required = true)
    @Nonnull
    private final String street;

    public Address(String city, String country, String street) {
        this.city = city;
        this.country = country;
        this.street = street;
    }

    public Address(com.szberko.hotelreview.service.dto.Address address){
        this.city = address.getCity();
        this.country = address.getCountry();
        this.street = address.getStreet();
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getStreet() {
        return street;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(city, address.city) &&
                Objects.equals(country, address.country) &&
                Objects.equals(street, address.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, country, street);
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", street='" + street + '\'' +
                '}';
    }
}
