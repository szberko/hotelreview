package com.szberko.hotelreview.controller.dto;

import java.util.Objects;

public class HotelResponse {

    private final String name;
    private final Address address;
    private final String image;
    private final String description;
    private final GeoLocation geoLocation;

    private HotelResponse(Builder builder) {
        name = builder.name;
        address = builder.address;
        image = builder.image;
        description = builder.description;
        geoLocation = builder.geoLocation;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public String getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }

    public GeoLocation getGeoLocation() {
        return geoLocation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HotelResponse that = (HotelResponse) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(address, that.address) &&
                Objects.equals(image, that.image) &&
                Objects.equals(description, that.description) &&
                Objects.equals(geoLocation, that.geoLocation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, address, image, description, geoLocation);
    }

    @Override
    public String toString() {
        return "HotelResponse{" +
                "name='" + name + '\'' +
                ", address=" + address +
                ", image='" + image + '\'' +
                ", description='" + description + '\'' +
                ", geoLocation=" + geoLocation +
                '}';
    }

    public static final class Builder {
        private String name;
        private Address address;
        private String image;
        private String description;
        private GeoLocation geoLocation;

        public Builder() {
        }

        public Builder withName(String val) {
            name = val;
            return this;
        }

        public Builder withAddress(Address val) {
            address = val;
            return this;
        }

        public Builder withImage(String val) {
            image = val;
            return this;
        }

        public Builder withDescription(String val) {
            description = val;
            return this;
        }

        public Builder withGeoLocation(GeoLocation val) {
            geoLocation = val;
            return this;
        }

        public HotelResponse build() {
            return new HotelResponse(this);
        }
    }
}
