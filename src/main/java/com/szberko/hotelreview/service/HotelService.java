package com.szberko.hotelreview.service;


import com.szberko.hotelreview.service.dto.HotelRequest;
import com.szberko.hotelreview.service.dto.HotelResponse;

import java.util.List;

public interface HotelService {

    List<HotelResponse> getAllHotels();
    HotelResponse getAHotel(final long id);
    HotelResponse createHotel(final HotelRequest hotelRequest);
    HotelResponse editHotel(final long id, final HotelRequest hotelRequest);
}
