package com.szberko.hotelreview.provider;

import com.szberko.hotelreview.service.dto.GeoLocation;

public class GeoLocationProvider {

    private static double lat = 4;
    private static double lon = 5;

    public static GeoLocation aGeoLocation(){
        return new GeoLocation(lat, lon);
    }
}
