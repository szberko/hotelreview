package com.symphony.hotelreview.controller.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

@JsonDeserialize(builder = HotelRequest.Builder.class)
public class HotelRequest {

    @ApiModelProperty(notes = "Name of your hotel", example = "Hotel 1", required = true, position = 0)
    private final String name;
    @ApiModelProperty(notes = "Description of your hotel", example = "Description", required = true, position = 1)
    private final String description;
    @ApiModelProperty(notes = "Address of your hotel", required = true, position = 2)
    private final Address address;
    @ApiModelProperty(notes = "Image from CDN source of your hotel", required = true, position = 3)
    private final String image;
    @ApiModelProperty(notes = "GeoLocation of your hotel", required = true, position = 4)
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
