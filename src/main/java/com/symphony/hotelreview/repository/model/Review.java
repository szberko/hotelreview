package com.symphony.hotelreview.repository.model;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String review;
    private Integer rating;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User reviewer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    @OneToMany(mappedBy = "review")
    private Set<RatingOpinion> ratingOpinions;

    public Review() {
    }

    private Review(Builder builder) {
        id = builder.id;
        review = builder.review;
        rating = builder.rating;
        reviewer = builder.reviewer;
        hotel = builder.hotel;
        ratingOpinions = builder.ratingOpinions;
    }


    public Long getId() {
        return id;
    }

    public String getReview() {
        return review;
    }

    public Integer getRating() {
        return rating;
    }

    public User getReviewer() {
        return reviewer;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public Set<RatingOpinion> getRatingOpinions() {
        return ratingOpinions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review = (Review) o;
        return Objects.equals(id, review.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", review='" + review + '\'' +
                ", rating=" + rating +
                ", reviewer=" + reviewer +
                ", hotel=" + hotel +
                ", ratingOpinions=" + ratingOpinions +
                '}';
    }

    public static final class Builder {
        private Long id;
        private String review;
        private Integer rating;
        private User reviewer;
        private Hotel hotel;
        private Set<RatingOpinion> ratingOpinions;

        public Builder() {
        }

        public Builder withId(Long val) {
            id = val;
            return this;
        }

        public Builder withReview(String val) {
            review = val;
            return this;
        }

        public Builder withRating(Integer val) {
            rating = val;
            return this;
        }

        public Builder withReviewer(User val) {
            reviewer = val;
            return this;
        }

        public Builder withHotel(Hotel val) {
            hotel = val;
            return this;
        }

        public Builder withRatingOpinions(Set<RatingOpinion> val) {
            ratingOpinions = val;
            return this;
        }

        public Review build() {
            return new Review(this);
        }
    }
}
