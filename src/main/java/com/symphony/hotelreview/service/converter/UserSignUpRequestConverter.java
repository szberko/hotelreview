package com.symphony.hotelreview.service.converter;

import com.symphony.hotelreview.repository.model.User;
import com.symphony.hotelreview.service.dto.UserSignUpRequest;
import org.springframework.stereotype.Component;

@Component("serviceUserSignUpRequestConverter")
public class UserSignUpRequestConverter implements ServiceDTOConverter<UserSignUpRequest, User> {

    @Override
    public User convert(UserSignUpRequest input) {
        return new User.Builder()
                .withEmail(input.getEmail())
                .withDisplayName(input.getDisplayName())
                .withPassword(input.getPassword())
                .build();
    }
}
