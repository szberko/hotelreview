package com.symphony.hotelreview.controller.converter;

import com.symphony.hotelreview.controller.dto.UserSignUpResponse;
import org.springframework.stereotype.Component;

@Component("controllerUserSignUpResponseConverter")
public class UserSingUpResponseConverter implements ControllerDTOConverter<com.symphony.hotelreview.service.dto.UserSignUpResponse, UserSignUpResponse> {

    @Override
    public UserSignUpResponse convert(com.symphony.hotelreview.service.dto.UserSignUpResponse input) {
        return new UserSignUpResponse(input.getEmail(), input.getDisplayName());
    }
}
