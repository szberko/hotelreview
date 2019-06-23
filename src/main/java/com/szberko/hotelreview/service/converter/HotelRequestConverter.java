package com.szberko.hotelreview.service.converter;

import com.szberko.hotelreview.repository.model.Hotel;
import com.szberko.hotelreview.service.dto.HotelRequest;
import org.springframework.stereotype.Component;

@Component("serviceHotelRequestConverter")
public class HotelRequestConverter implements ServiceDTOConverter<HotelRequest, Hotel> {

    @Override
    public Hotel convert(HotelRequest input) {
        return new Hotel.Builder()
                .withName(input.getName())
                .withDescription(input.getDescription())
                .withImage(input.getImage())
                .withCity(input.getAddress().getCity())
                .withCountry(input.getAddress().getCountry())
                .withStreet(input.getAddress().getStreet())
                .withLat(input.getGeoLocation().getLat())
                .withLon(input.getGeoLocation().getLon())
                .build();
    }
}
