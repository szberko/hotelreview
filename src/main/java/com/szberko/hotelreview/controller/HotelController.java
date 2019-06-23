package com.szberko.hotelreview.controller;

import com.szberko.hotelreview.controller.converter.ControllerDTOConverter;
import com.szberko.hotelreview.controller.converter.HotelRequestConverter;
import com.szberko.hotelreview.controller.converter.HotelResponseConverter;
import com.szberko.hotelreview.controller.dto.HotelRequest;
import com.szberko.hotelreview.service.HotelService;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class HotelController {

    private final HotelService hotelService;
    private final ControllerDTOConverter<com.szberko.hotelreview.service.dto.HotelResponse, com.szberko.hotelreview.controller.dto.HotelResponse> controllerHotelResponseConverter;
    private final ControllerDTOConverter<HotelRequest, com.szberko.hotelreview.service.dto.HotelRequest> controllerHotelRequestConverter;

    public HotelController(final HotelService hotelService,
                           final HotelResponseConverter controllerHotelResponseConverter,
                           final HotelRequestConverter controllerHotelRequestConverter) {
        this.hotelService = hotelService;
        this.controllerHotelResponseConverter = controllerHotelResponseConverter;
        this.controllerHotelRequestConverter = controllerHotelRequestConverter;
    }

    @GetMapping(value = "/hotels", produces = "application/json")
    public List<com.szberko.hotelreview.controller.dto.HotelResponse> getAllHotels(){
        return hotelService.getAllHotels().stream().map(controllerHotelResponseConverter::convert).collect(Collectors.toList());
    }

    @GetMapping(value = "hotels/{id}", produces = "application/json")
    public com.szberko.hotelreview.controller.dto.HotelResponse getOneHotel(@Valid @NonNull @PathVariable final Long id){
        return controllerHotelResponseConverter.convert(hotelService.getAHotel(id));
    }

    @PostMapping(value = "/hotels", produces = "application/json")
    public com.szberko.hotelreview.controller.dto.HotelResponse createHotel(@Valid @RequestBody final HotelRequest payload){
        final com.szberko.hotelreview.service.dto.HotelRequest hotelRequest = controllerHotelRequestConverter.convert(payload);
        final com.szberko.hotelreview.service.dto.HotelResponse hotelResponse = hotelService.createHotel(hotelRequest);

        return controllerHotelResponseConverter.convert(hotelResponse);
    }

    @PutMapping(value = "/hotels/{id}", produces = "application/json")
    public com.szberko.hotelreview.controller.dto.HotelResponse editHotel(@Valid @PathVariable @NotNull final Long id, @Valid @RequestBody final HotelRequest payload){
        final com.szberko.hotelreview.service.dto.HotelRequest hotelRequest = controllerHotelRequestConverter.convert(payload);
        final com.szberko.hotelreview.service.dto.HotelResponse hotelResponse = hotelService.editHotel(id, hotelRequest);

        return controllerHotelResponseConverter.convert(hotelResponse);
    }
}
