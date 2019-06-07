package com.symphony.hotelreview.service.converter;

import com.symphony.hotelreview.service.dto.Address;
import com.symphony.hotelreview.service.dto.GeoLocation;
import com.symphony.hotelreview.service.dto.HotelResponse;
import org.springframework.stereotype.Component;

@Component("serviceHotelResponseConverter")
public class HotelResponseConverter implements ServiceDTOConverter<com.symphony.hotelreview.repository.model.Hotel, HotelResponse> {

    @Override
    public HotelResponse convert(com.symphony.hotelreview.repository.model.Hotel input) {
        return new HotelResponse.Builder()
                .withName(input.getName())
                .withDescription(input.getDescription())
                .withAddress(new Address(input.getCity(), input.getCountry(), input.getStreet()))
                .withImage(input.getImage())
                .withGeoLocation(new GeoLocation(input.getLat(), input.getLon()))
                .build();
    }
}
