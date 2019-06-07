package com.symphony.hotelreview.repository;

import com.symphony.hotelreview.repository.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
