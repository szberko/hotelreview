package com.szberko.hotelreview.service.converter;

import com.szberko.hotelreview.repository.model.User;
import com.szberko.hotelreview.service.dto.UserSignUpRequest;
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
