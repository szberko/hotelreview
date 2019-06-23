package com.szberko.hotelreview.repository;

import com.szberko.hotelreview.repository.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
}
