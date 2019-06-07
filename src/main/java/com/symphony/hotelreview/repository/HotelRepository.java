package com.symphony.hotelreview.repository;

import com.symphony.hotelreview.repository.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
}
