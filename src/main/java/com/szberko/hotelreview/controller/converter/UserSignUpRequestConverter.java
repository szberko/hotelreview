package com.szberko.hotelreview.controller.converter;

import com.szberko.hotelreview.controller.dto.UserSignUpRequest;
import org.springframework.stereotype.Component;

@Component("controllerUserSignUpRequestConverter")
public class UserSignUpRequestConverter implements ControllerDTOConverter<UserSignUpRequest, com.szberko.hotelreview.service.dto.UserSignUpRequest> {

    @Override
    public com.szberko.hotelreview.service.dto.UserSignUpRequest convert(UserSignUpRequest input) {
        return new com.szberko.hotelreview.service.dto.UserSignUpRequest(input.getEmail(), input.getDisplayName(), input.getPassword());
    }
}
