package com.szberko.hotelreview.controller;

import com.szberko.hotelreview.controller.converter.ControllerDTOConverter;
import com.szberko.hotelreview.controller.converter.UserSignUpRequestConverter;
import com.szberko.hotelreview.controller.converter.UserSingUpResponseConverter;
import com.szberko.hotelreview.controller.dto.UserSignUpRequest;
import com.szberko.hotelreview.controller.dto.UserSignUpResponse;
import com.szberko.hotelreview.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;
    private final ControllerDTOConverter<UserSignUpRequest, com.szberko.hotelreview.service.dto.UserSignUpRequest> controllerUserSignUpRequestConverter;
    private final ControllerDTOConverter<com.szberko.hotelreview.service.dto.UserSignUpResponse, UserSignUpResponse> controllerUserSignUpResponseConverter;

    public UserController(final UserService userService,
                          final UserSignUpRequestConverter controllerUserSignUpRequestConverter,
                          final UserSingUpResponseConverter controllerUserSignUpResponseConverter) {
        this.userService = userService;
        this.controllerUserSignUpRequestConverter = controllerUserSignUpRequestConverter;
        this.controllerUserSignUpResponseConverter = controllerUserSignUpResponseConverter;
    }

    @PostMapping("/users")
    public UserSignUpResponse signUp(@RequestBody final UserSignUpRequest payload){
        final com.szberko.hotelreview.service.dto.UserSignUpRequest userSignUpRequest = controllerUserSignUpRequestConverter.convert(payload);
        final com.szberko.hotelreview.service.dto.UserSignUpResponse userSignUpResponse = userService.signUp(userSignUpRequest);

        return controllerUserSignUpResponseConverter.convert(userSignUpResponse);
    }
}
