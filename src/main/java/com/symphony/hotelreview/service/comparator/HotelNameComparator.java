package com.symphony.hotelreview.service.comparator;

import com.symphony.hotelreview.service.dto.HotelResponse;
import org.springframework.stereotype.Component;

import java.util.Comparator;

@Component
public class HotelNameComparator implements Comparator<HotelResponse> {

    @Override
    public int compare(HotelResponse o1, HotelResponse o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
