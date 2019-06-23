package com.szberko.hotelreview.repository.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class RatingOpinion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Opinion opinion;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "review_id")
    private Review review;

    public RatingOpinion() {
    }

    public RatingOpinion(Opinion opinion, User user, Review review) {
        this.opinion = opinion;
        this.user = user;
        this.review = review;
    }

    public Long getId() {
        return id;
    }

    public Opinion getOpinion() {
        return opinion;
    }

    public User getUser() {
        return user;
    }

    public Review getReview() {
        return review;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RatingOpinion that = (RatingOpinion) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "RatingOpinion{" +
                "id=" + id +
                ", opinion=" + opinion +
                ", user=" + user +
                ", review=" + review +
                '}';
    }
}
