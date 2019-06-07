package com.symphony.hotelreview.controller.dto;

public class GeoLocation {

    private final Double lat;
    private final Double lon;

    public GeoLocation(Double lat, Double lon) {
        this.lat = lat;
        this.lon = lon;
    }

    public GeoLocation(com.symphony.hotelreview.service.dto.GeoLocation geoLocation){
        this.lat = geoLocation.getLat();
        this.lon = geoLocation.getLon();
    }

    public Double getLat() {
        return lat;
    }

    public Double getLon() {
        return lon;
    }

    @Override
    public String toString() {
        return "GeoLocation{" +
                "lat=" + lat +
                ", lon=" + lon +
                '}';
    }
}
