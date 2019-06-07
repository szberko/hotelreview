package com.symphony.hotelreview.provider;

import com.symphony.hotelreview.service.dto.GeoLocation;

public class GeoLocationProvider {

    private static double lat = 4;
    private static double lon = 5;

    public static GeoLocation aGeoLocation(){
        return new GeoLocation(lat, lon);
    }
}
