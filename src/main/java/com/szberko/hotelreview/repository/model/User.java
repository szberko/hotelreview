package com.szberko.hotelreview.repository.model;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String email;
    private String displayName;
    private String password;

    @OneToMany(mappedBy = "reviewer")
    private Set<Review> reviews;

    @OneToMany(mappedBy = "user")
    private Set<Favorite> favorites;

    @OneToMany(mappedBy = "user")
    private Set<RatingOpinion> ratingOpinions;

    public User() {
    }

    private User(Builder builder) {
        id = builder.id;
        email = builder.email;
        displayName = builder.displayName;
        password = builder.password;
        reviews = builder.reviews;
        favorites = builder.favorites;
        ratingOpinions = builder.ratingOpinions;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getPassword() {
        return password;
    }

    public Set<Review> getReviews() {
        return reviews;
    }

    public Set<Favorite> getFavorites() {
        return favorites;
    }

    public Set<RatingOpinion> getRatingOpinions() {
        return ratingOpinions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", displayName='" + displayName + '\'' +
                ", password='" + password + '\'' +
                ", reviews=" + reviews +
                ", favorites=" + favorites +
                ", ratingOpinions=" + ratingOpinions +
                '}';
    }

    public static final class Builder {
        private Long id;
        private String email;
        private String displayName;
        private String password;
        private Set<Review> reviews;
        private Set<Favorite> favorites;
        private Set<RatingOpinion> ratingOpinions;

        public Builder() {
        }

        public Builder withId(Long val) {
            id = val;
            return this;
        }

        public Builder withEmail(String val) {
            email = val;
            return this;
        }

        public Builder withDisplayName(String val) {
            displayName = val;
            return this;
        }

        public Builder withPassword(String val) {
            password = val;
            return this;
        }

        public Builder withReviews(Set<Review> val) {
            reviews = val;
            return this;
        }

        public Builder withFavorites(Set<Favorite> val) {
            favorites = val;
            return this;
        }

        public Builder withRatingOpinions(Set<RatingOpinion> val) {
            ratingOpinions = val;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
