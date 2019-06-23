package com.szberko.hotelreview.controller.dto;

import io.swagger.annotations.ApiModelProperty;

import javax.annotation.Nonnull;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Objects;

public class ReviewRequest {

    @ApiModelProperty(notes = "Your review message", example = "review message", required = true, position = 0)
    @Nonnull
    private final String review;
    @ApiModelProperty(notes = "Your rating on the hotel from: 1 - 5", example = "3", required = true, position = 0)
    @Nonnull
    @Min(0)
    @Max(5)
    private final Integer rating;
    @ApiModelProperty(notes = "Your rating on the hotel from: 1 - 5", example = "3", required = true, position = 0)
    @Nonnull
    //TODO: This user should come from the session. Unfortunately there was no time for that.
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
