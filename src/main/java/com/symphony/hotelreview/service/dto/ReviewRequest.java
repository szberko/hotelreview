package com.symphony.hotelreview.service.dto;

import java.util.Objects;

public class ReviewRequest {

    private final String review;
    private final Integer rating;
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


}
