package com.szberko.hotelreview.repository.model;

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

    public void setId(Long id) {
        this.id = id;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public void setReviewer(User reviewer) {
        this.reviewer = reviewer;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public void setRatingOpinions(Set<RatingOpinion> ratingOpinions) {
        this.ratingOpinions = ratingOpinions;
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
