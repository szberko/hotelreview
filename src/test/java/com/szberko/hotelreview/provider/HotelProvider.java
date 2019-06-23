package com.szberko.hotelreview.provider;

import com.szberko.hotelreview.repository.model.Hotel;
import com.szberko.hotelreview.service.dto.HotelResponse;

import static com.szberko.hotelreview.provider.GeoLocationProvider.aGeoLocation;

public class HotelProvider {
    private static Long id = 1L;
    private static String name = "hotel";
    private static String city = "city";
    private static String country = "country";
    private static String street = "street";
    private static String image = "image";
    private static String description = "description";
    private static double lat = 4L;
    private static double lon = 5L;

    public static Hotel aRepositoryHotel(){
        return new Hotel.Builder()
                .withId(id)
                .withName(name)
                .withCity(city)
                .withCountry(country)
                .withStreet(street)
                .withImage(image)
                .withDescription(description)
                .withLat(lat)
                .withLon(lon)
                .build();
    }

    public static HotelResponse aSeviceHotelResponse(){
        return new HotelResponse.Builder()
                .withName(name)
                .withDescription(description)
                .withImage(image)
                .withAddress(AddressProvider.anAddress())
                .withGeoLocation(aGeoLocation())
                .build();
    }
}
