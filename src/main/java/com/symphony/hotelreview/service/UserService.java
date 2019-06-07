package com.symphony.hotelreview.service;

import com.symphony.hotelreview.service.dto.UserSignUpRequest;
import com.symphony.hotelreview.service.dto.UserSignUpResponse;

public interface UserService {

    UserSignUpResponse signUp(UserSignUpRequest userSignUpRequest);

}
