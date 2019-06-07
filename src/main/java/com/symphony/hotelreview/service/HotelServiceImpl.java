package com.symphony.hotelreview.service;

import com.symphony.hotelreview.repository.HotelRepository;
import com.symphony.hotelreview.repository.model.Hotel;
import com.symphony.hotelreview.service.converter.HotelRequestConverter;
import com.symphony.hotelreview.service.converter.HotelResponseConverter;
import com.symphony.hotelreview.service.converter.ServiceDTOConverter;
import com.symphony.hotelreview.service.dto.HotelRequest;
import com.symphony.hotelreview.service.dto.HotelResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HotelServiceImpl implements HotelService {

    private final HotelRepository hotelRepository;
    private final ServiceDTOConverter<com.symphony.hotelreview.repository.model.Hotel, HotelResponse> serviceHotelResponseConverter;
    private final ServiceDTOConverter<HotelRequest, Hotel> serviceHotelRequestConverter;

    public HotelServiceImpl(final HotelRepository hotelRepository,
                            final HotelResponseConverter serviceHotelResponseConverter,
                            final HotelRequestConverter serviceHotelRequestConverter) {
        this.hotelRepository = hotelRepository;
        this.serviceHotelResponseConverter = serviceHotelResponseConverter;
        this.serviceHotelRequestConverter = serviceHotelRequestConverter;
    }

    @Override
    public List<HotelResponse> getAllHotels() {
        final List<com.symphony.hotelreview.repository.model.Hotel> hotelsFromDB = hotelRepository.findAll();
        final List<HotelResponse> hotelResponses = hotelsFromDB.stream().map(serviceHotelResponseConverter::convert).collect(Collectors.toList());
        return hotelResponses;
    }

    @Override
    public HotelResponse createHotel(HotelRequest hotelRequest) {
        final Hotel newHotel = serviceHotelRequestConverter.convert(hotelRequest);
        final Hotel savedHotel = hotelRepository.save(newHotel);
        return serviceHotelResponseConverter.convert(savedHotel);
    }
}
