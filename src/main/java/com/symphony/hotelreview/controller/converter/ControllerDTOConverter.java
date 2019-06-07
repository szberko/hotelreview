package com.symphony.hotelreview.controller.converter;

public interface ControllerDTOConverter<T, R> {

    R convert(T input);
}
