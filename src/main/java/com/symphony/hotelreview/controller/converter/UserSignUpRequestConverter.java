package com.symphony.hotelreview.controller.converter;

import com.symphony.hotelreview.controller.dto.UserSignUpRequest;
import org.springframework.stereotype.Component;

@Component("controllerUserSignUpRequestConverter")
public class UserSignUpRequestConverter implements ControllerDTOConverter<UserSignUpRequest, com.symphony.hotelreview.service.dto.UserSignUpRequest> {

    @Override
    public com.symphony.hotelreview.service.dto.UserSignUpRequest convert(UserSignUpRequest input) {
        return new com.symphony.hotelreview.service.dto.UserSignUpRequest(input.getEmail(), input.getDisplayName(), input.getPassword());
    }
}
