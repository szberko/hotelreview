package com.symphony.hotelreview.controller;

import com.symphony.hotelreview.controller.converter.ControllerDTOConverter;
import com.symphony.hotelreview.controller.converter.HotelRequestConverter;
import com.symphony.hotelreview.controller.converter.HotelResponseConverter;
import com.symphony.hotelreview.controller.dto.HotelRequest;
import com.symphony.hotelreview.controller.dto.HotelResponse;
import com.symphony.hotelreview.service.HotelService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class HotelController {

    private final HotelService hotelService;
    private final ControllerDTOConverter<com.symphony.hotelreview.service.dto.HotelResponse, HotelResponse> controllerHotelResponseConverter;
    private final ControllerDTOConverter<HotelRequest, com.symphony.hotelreview.service.dto.HotelRequest> controllerHotelRequestConverter;

    public HotelController(final HotelService hotelService,
                           final HotelResponseConverter controllerHotelResponseConverter,
                           final HotelRequestConverter controllerHotelRequestConverter) {
        this.hotelService = hotelService;
        this.controllerHotelResponseConverter = controllerHotelResponseConverter;
        this.controllerHotelRequestConverter = controllerHotelRequestConverter;
    }

    @GetMapping(value = "/hotels", produces = "application/json")
    public List<HotelResponse> getAllHotels(){
        return hotelService.getAllHotels().stream().map(controllerHotelResponseConverter::convert).collect(Collectors.toList());
    }

    @PostMapping(value = "/hotels", produces = "application/json")
    public HotelResponse createHotel(@RequestBody final HotelRequest payload){
        final com.symphony.hotelreview.service.dto.HotelRequest hotelRequest = controllerHotelRequestConverter.convert(payload);
        final com.symphony.hotelreview.service.dto.HotelResponse hotelResponse = hotelService.createHotel(hotelRequest);

        return controllerHotelResponseConverter.convert(hotelResponse);
    }
}
