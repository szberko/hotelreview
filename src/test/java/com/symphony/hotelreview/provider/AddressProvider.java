package com.symphony.hotelreview.provider;

import com.symphony.hotelreview.service.dto.Address;

public class AddressProvider {

    private static String city = "city";
    private static String country = "country";
    private static String street = "street";

    public static Address anAddress(){
        return new Address(city, country, street);
    }
}
