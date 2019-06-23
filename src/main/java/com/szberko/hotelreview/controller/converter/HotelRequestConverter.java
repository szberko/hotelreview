package com.szberko.hotelreview.controller.converter;

import com.szberko.hotelreview.controller.dto.HotelRequest;
import com.szberko.hotelreview.service.dto.Address;
import com.szberko.hotelreview.service.dto.GeoLocation;
import org.springframework.stereotype.Component;

@Component("controllerHotelRequestConverter")
public class HotelRequestConverter implements ControllerDTOConverter<HotelRequest, com.szberko.hotelreview.service.dto.HotelRequest> {

    @Override
    public com.szberko.hotelreview.service.dto.HotelRequest convert(HotelRequest input) {
        return new com.szberko.hotelreview.service.dto.HotelRequest.Builder()
                .withName(input.getName())
                .withDescription(input.getDescription())
                .withAddress(new Address(input.getAddress()))
                .withGeoLocation(new GeoLocation(input.getGeoLocation()))
                .withImage(input.getImage())
                .build();
    }
}
