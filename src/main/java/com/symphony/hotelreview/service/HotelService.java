package com.symphony.hotelreview.service;


import com.symphony.hotelreview.service.dto.HotelRequest;
import com.symphony.hotelreview.service.dto.HotelResponse;

import java.util.List;

public interface HotelService {

    List<HotelResponse> getAllHotels();
    HotelResponse createHotel(final HotelRequest hotelRequest);
}
