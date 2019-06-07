package com.symphony.hotelreview.service.converter;

public interface ServiceDTOConverter<T, R> {

    R convert(T input);
}
