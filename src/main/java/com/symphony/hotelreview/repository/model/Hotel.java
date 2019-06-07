package com.symphony.hotelreview.repository.model;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String city;
    private String country;
    private String street;
    private String image;
    private String description;
    private double lat;
    private double lon;

    @OneToMany(mappedBy = "hotel")
    private Set<Review> reviews;

    @OneToMany(mappedBy = "hotel")
    private Set<Favorite> favoritedBy;

    public Hotel() {
    }

    private Hotel(Builder builder) {
        id = builder.id;
        name = builder.name;
        city = builder.city;
        country = builder.country;
        street = builder.street;
        image = builder.image;
        description = builder.description;
        lat = builder.lat;
        lon = builder.lon;
        reviews = builder.reviews;
        favoritedBy = builder.favoritedBy;
    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
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

    public String getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }

    public Set<Review> getReviews() {
        return reviews;
    }

    public Set<Favorite> getFavoritedBy() {
        return favoritedBy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hotel hotel = (Hotel) o;
        return Objects.equals(id, hotel.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", street='" + street + '\'' +
                ", image='" + image + '\'' +
                ", description='" + description + '\'' +
                ", lat='" + lat + '\'' +
                ", lon='" + lon + '\'' +
                ", reviews=" + reviews +
                ", favoritedBy=" + favoritedBy +
                '}';
    }

    public static final class Builder {
        private Long id;
        private String name;
        private String city;
        private String country;
        private String street;
        private String image;
        private String description;
        private double lat;
        private double lon;
        private Set<Review> reviews;
        private Set<Favorite> favoritedBy;

        public Builder() {
        }

        public Builder withId(Long val) {
            id = val;
            return this;
        }

        public Builder withName(String val) {
            name = val;
            return this;
        }

        public Builder withCity(String val) {
            city = val;
            return this;
        }

        public Builder withCountry(String val) {
            country = val;
            return this;
        }

        public Builder withStreet(String val) {
            street = val;
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

        public Builder withLat(double val) {
            lat = val;
            return this;
        }

        public Builder withLon(double val) {
            lon = val;
            return this;
        }

        public Builder withReviews(Set<Review> val) {
            reviews = val;
            return this;
        }

        public Builder withFavoritedBy(Set<Favorite> val) {
            favoritedBy = val;
            return this;
        }

        public Hotel build() {
            return new Hotel(this);
        }
    }
}
