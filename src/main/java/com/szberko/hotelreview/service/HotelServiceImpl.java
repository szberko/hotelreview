package com.szberko.hotelreview.service;

import com.szberko.hotelreview.exceptions.HotelNotFoundException;
import com.szberko.hotelreview.repository.HotelRepository;
import com.szberko.hotelreview.repository.model.Hotel;
import com.szberko.hotelreview.service.comparator.HotelNameComparator;
import com.szberko.hotelreview.service.converter.HotelRequestConverter;
import com.szberko.hotelreview.service.converter.HotelResponseConverter;
import com.szberko.hotelreview.service.converter.ServiceDTOConverter;
import com.szberko.hotelreview.service.dto.HotelRequest;
import com.szberko.hotelreview.service.dto.HotelResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HotelServiceImpl implements HotelService {

    private final HotelRepository hotelRepository;
    private final ServiceDTOConverter<Hotel, HotelResponse> serviceHotelResponseConverter;
    private final ServiceDTOConverter<HotelRequest, Hotel> serviceHotelRequestConverter;
    private final HotelNameComparator hotelNameComparator;

    public HotelServiceImpl(final HotelRepository hotelRepository,
                            final HotelResponseConverter serviceHotelResponseConverter,
                            final HotelRequestConverter serviceHotelRequestConverter,
                            final HotelNameComparator hotelNameComparator) {
        this.hotelRepository = hotelRepository;
        this.serviceHotelResponseConverter = serviceHotelResponseConverter;
        this.serviceHotelRequestConverter = serviceHotelRequestConverter;
        this.hotelNameComparator = hotelNameComparator;
    }

    @Override
    public List<HotelResponse> getAllHotels() {
        final List<Hotel> hotelsFromDB = hotelRepository.findAll();
        final List<HotelResponse> hotelResponses = hotelsFromDB.stream().map(serviceHotelResponseConverter::convert).collect(Collectors.toList());
        final List<HotelResponse> sortedHotelResponse = hotelResponses.stream().sorted(hotelNameComparator).collect(Collectors.toList());
        return sortedHotelResponse;
    }

    @Override
    public HotelResponse getAHotel(final long id) {
        final Optional<Hotel> foundHotel = hotelRepository.findById(id);
        foundHotel.orElseThrow(() -> new HotelNotFoundException("Hotel with id " + id + " doesn't exists"));

        return serviceHotelResponseConverter.convert(foundHotel.get());
    }

    @Override
    public HotelResponse createHotel(final HotelRequest hotelRequest) {
        final Hotel newHotel = serviceHotelRequestConverter.convert(hotelRequest);
        final Hotel savedHotel = hotelRepository.save(newHotel);
        return serviceHotelResponseConverter.convert(savedHotel);
    }

    @Override
    public HotelResponse editHotel(final long id, final HotelRequest hotelRequest) {
        final Optional<Hotel> foundHotel = hotelRepository.findById(id);
        foundHotel.orElseThrow(() -> new HotelNotFoundException("Hotel with id " + id + " doesn't exists"));

        final Hotel hotel = foundHotel.get();
        hotel.setId(id);
        hotel.setName(hotelRequest.getName());
        hotel.setDescription(hotelRequest.getDescription());
        hotel.setImage(hotelRequest.getImage());
        hotel.setCity(hotelRequest.getAddress().getCity());
        hotel.setCountry(hotelRequest.getAddress().getCountry());
        hotel.setStreet(hotelRequest.getAddress().getStreet());
        hotel.setLat(hotelRequest.getGeoLocation().getLat());
        hotel.setLon(hotelRequest.getGeoLocation().getLon());

        final Hotel updatedHotel = hotelRepository.save(hotel);

        return serviceHotelResponseConverter.convert(updatedHotel);
    }
}
