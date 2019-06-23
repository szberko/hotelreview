package com.szberko.hotelreview.controller.converter;

import com.szberko.hotelreview.controller.dto.UserSignUpResponse;
import org.springframework.stereotype.Component;

@Component("controllerUserSignUpResponseConverter")
public class UserSingUpResponseConverter implements ControllerDTOConverter<com.szberko.hotelreview.service.dto.UserSignUpResponse, UserSignUpResponse> {

    @Override
    public UserSignUpResponse convert(com.szberko.hotelreview.service.dto.UserSignUpResponse input) {
        return new UserSignUpResponse(input.getEmail(), input.getDisplayName());
    }
}
