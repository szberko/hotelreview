package com.szberko.hotelreview.service;

import com.szberko.hotelreview.service.dto.UserSignUpRequest;
import com.szberko.hotelreview.service.dto.UserSignUpResponse;

public interface UserService {

    UserSignUpResponse signUp(UserSignUpRequest userSignUpRequest);

}
