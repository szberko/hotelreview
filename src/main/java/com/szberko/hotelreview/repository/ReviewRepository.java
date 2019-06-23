package com.szberko.hotelreview.repository;

import com.szberko.hotelreview.repository.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
