package com.szberko.hotelreview.controller.converter;

import com.szberko.hotelreview.controller.dto.Address;
import com.szberko.hotelreview.controller.dto.GeoLocation;
import com.szberko.hotelreview.controller.dto.HotelResponse;
import org.springframework.stereotype.Component;

@Component("controllerHotelResponseConverter")
public class HotelResponseConverter implements ControllerDTOConverter<com.szberko.hotelreview.service.dto.HotelResponse, HotelResponse> {

    @Override
    public HotelResponse convert(com.szberko.hotelreview.service.dto.HotelResponse input) {
        return new HotelResponse.Builder()
                .withName(input.getName())
                .withDescription(input.getDescription())
                .withAddress(new Address(input.getAddress()))
                .withImage(input.getImage())
                .withGeoLocation(new GeoLocation(input.getGeoLocation()))
                .build();
    }
}
