package com.symphony.hotelreview.service.dto;

import java.util.Objects;

public class HotelRequest {

    private final String name;
    private final String description;
    private final Address address;
    private final String image;
    private final GeoLocation geoLocation;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Address getAddress() {
        return address;
    }

    public String getImage() {
        return image;
    }

    public GeoLocation getGeoLocation() {
        return geoLocation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HotelRequest that = (HotelRequest) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(description, that.description) &&
                Objects.equals(address, that.address) &&
                Objects.equals(image, that.image) &&
                Objects.equals(geoLocation, that.geoLocation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, address, image, geoLocation);
    }

    @Override
    public String toString() {
        return "HotelRequest{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", address=" + address +
                ", image='" + image + '\'' +
                ", geoLocation=" + geoLocation +
                '}';
    }

    private HotelRequest(Builder builder) {
        name = builder.name;
        description = builder.description;
        address = builder.address;
        image = builder.image;
        geoLocation = builder.geoLocation;
    }

    public static final class Builder {
        private String name;
        private String description;
        private Address address;
        private String image;
        private GeoLocation geoLocation;

        public Builder() {
        }

        public Builder withName(String val) {
            name = val;
            return this;
        }

        public Builder withDescription(String val) {
            description = val;
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

        public Builder withGeoLocation(GeoLocation val) {
            geoLocation = val;
            return this;
        }

        public HotelRequest build() {
            return new HotelRequest(this);
        }
    }
}
