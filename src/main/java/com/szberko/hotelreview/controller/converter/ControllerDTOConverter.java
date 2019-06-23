package com.szberko.hotelreview.controller.converter;

public interface ControllerDTOConverter<T, R> {

    R convert(T input);
}
