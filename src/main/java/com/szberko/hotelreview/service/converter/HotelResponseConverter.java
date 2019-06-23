package com.szberko.hotelreview.service.converter;

import com.szberko.hotelreview.service.dto.Address;
import com.szberko.hotelreview.service.dto.GeoLocation;
import com.szberko.hotelreview.service.dto.HotelResponse;
import com.szberko.hotelreview.repository.model.Hotel;
import org.springframework.stereotype.Component;

@Component("serviceHotelResponseConverter")
public class HotelResponseConverter implements ServiceDTOConverter<Hotel, HotelResponse> {

    @Override
    public HotelResponse convert(Hotel input) {
        return new HotelResponse.Builder()
                .withName(input.getName())
                .withDescription(input.getDescription())
                .withAddress(new Address(input.getCity(), input.getCountry(), input.getStreet()))
                .withImage(input.getImage())
                .withGeoLocation(new GeoLocation(input.getLat(), input.getLon()))
                .build();
    }
}
