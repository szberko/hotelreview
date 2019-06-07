package com.symphony.hotelreview.service.converter;

import com.symphony.hotelreview.repository.model.User;
import com.symphony.hotelreview.service.dto.UserSignUpResponse;
import org.springframework.stereotype.Component;

@Component("serviceUserSignUpResponseConverter")
public class UserSignUpResponseConverter implements ServiceDTOConverter<User, UserSignUpResponse>{

    @Override
    public UserSignUpResponse convert(User input) {
        return new UserSignUpResponse(input.getEmail(), input.getDisplayName());
    }
}
