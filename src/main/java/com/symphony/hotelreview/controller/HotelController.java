package com.symphony.hotelreview.controller;

import com.symphony.hotelreview.controller.converter.ControllerDTOConverter;
import com.symphony.hotelreview.controller.converter.HotelRequestConverter;
import com.symphony.hotelreview.controller.converter.HotelResponseConverter;
import com.symphony.hotelreview.controller.dto.HotelRequest;
import com.symphony.hotelreview.controller.dto.HotelResponse;
import com.symphony.hotelreview.service.HotelService;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
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

    @GetMapping(value = "hotels/{id}", produces = "application/json")
    public HotelResponse getOneHotel(@Valid @NonNull @PathVariable final Long id){
        return controllerHotelResponseConverter.convert(hotelService.getAHotel(id));
    }

    @PostMapping(value = "/hotels", produces = "application/json")
    public HotelResponse createHotel(@Valid @RequestBody final HotelRequest payload){
        final com.symphony.hotelreview.service.dto.HotelRequest hotelRequest = controllerHotelRequestConverter.convert(payload);
        final com.symphony.hotelreview.service.dto.HotelResponse hotelResponse = hotelService.createHotel(hotelRequest);

        return controllerHotelResponseConverter.convert(hotelResponse);
    }

    @PutMapping(value = "/hotels/{id}", produces = "application/json")
    public HotelResponse editHotel(@Valid @PathVariable @NotNull final Long id, @Valid @RequestBody final HotelRequest payload){
        final com.symphony.hotelreview.service.dto.HotelRequest hotelRequest = controllerHotelRequestConverter.convert(payload);
        final com.symphony.hotelreview.service.dto.HotelResponse hotelResponse = hotelService.editHotel(id, hotelRequest);

        return controllerHotelResponseConverter.convert(hotelResponse);
    }
}
