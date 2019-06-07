package com.symphony.hotelreview.controller.converter;

import com.symphony.hotelreview.controller.dto.Address;
import com.symphony.hotelreview.controller.dto.GeoLocation;
import com.symphony.hotelreview.controller.dto.HotelResponse;
import org.springframework.stereotype.Component;

@Component("controllerHotelResponseConverter")
public class HotelResponseConverter implements ControllerDTOConverter<com.symphony.hotelreview.service.dto.HotelResponse, HotelResponse> {

    @Override
    public HotelResponse convert(com.symphony.hotelreview.service.dto.HotelResponse input) {
        return new HotelResponse.Builder()
                .withName(input.getName())
                .withDescription(input.getDescription())
                .withAddress(new Address(input.getAddress()))
                .withImage(input.getImage())
                .withGeoLocation(new GeoLocation(input.getGeoLocation()))
                .build();
    }
}
