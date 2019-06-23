package com.szberko.hotelreview.provider;

import com.szberko.hotelreview.service.dto.Address;

public class AddressProvider {

    private static String city = "city";
    private static String country = "country";
    private static String street = "street";

    public static Address anAddress(){
        return new Address(city, country, street);
    }
}
