package com.szberko.hotelreview.service.converter;

import com.szberko.hotelreview.repository.model.User;
import com.szberko.hotelreview.service.dto.UserSignUpResponse;
import org.springframework.stereotype.Component;

@Component("serviceUserSignUpResponseConverter")
public class UserSignUpResponseConverter implements ServiceDTOConverter<User, UserSignUpResponse>{

    @Override
    public UserSignUpResponse convert(User input) {
        return new UserSignUpResponse(input.getEmail(), input.getDisplayName());
    }
}
