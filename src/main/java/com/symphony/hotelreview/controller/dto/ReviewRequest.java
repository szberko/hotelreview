package com.symphony.hotelreview.controller.dto;

import javax.annotation.Nonnull;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Objects;

public class ReviewRequest {

    @Nonnull
    private final String review;
    @Nonnull
    @Min(0)
    @Max(5)
    private final Integer rating;
    @Nonnull
    private final Long userId;

    public ReviewRequest(String review, Integer rating, Long userId) {
        this.review = review;
        this.rating = rating;
        this.userId = userId;
    }

    public String getReview() {
        return review;
    }

    public Integer getRating() {
        return rating;
    }

    public Long getUserId() {
        return userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReviewRequest that = (ReviewRequest) o;
        return Objects.equals(review, that.review) &&
                Objects.equals(rating, that.rating) &&
                Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(review, rating, userId);
    }

    @Override
    public String toString() {
        return "ReviewRequest{" +
                "review='" + review + '\'' +
                ", rating=" + rating +
                ", userId=" + userId +
                '}';
    }
}
