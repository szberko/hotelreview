package com.symphony.hotelreview.controller.converter;

import com.symphony.hotelreview.controller.dto.HotelRequest;
import com.symphony.hotelreview.service.dto.Address;
import com.symphony.hotelreview.service.dto.GeoLocation;
import org.springframework.stereotype.Component;

@Component("controllerHotelRequestConverter")
public class HotelRequestConverter implements ControllerDTOConverter<HotelRequest, com.symphony.hotelreview.service.dto.HotelRequest> {

    @Override
    public com.symphony.hotelreview.service.dto.HotelRequest convert(HotelRequest input) {
        return new com.symphony.hotelreview.service.dto.HotelRequest.Builder()
                .withName(input.getName())
                .withDescription(input.getDescription())
                .withAddress(new Address(input.getAddress()))
                .withGeoLocation(new GeoLocation(input.getGeoLocation()))
                .withImage(input.getImage())
                .build();
    }
}
