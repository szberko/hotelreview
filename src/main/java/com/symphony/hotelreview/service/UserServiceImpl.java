package com.symphony.hotelreview.service;

import com.symphony.hotelreview.exceptions.UserAlreadyExistsException;
import com.symphony.hotelreview.repository.UserRepository;
import com.symphony.hotelreview.repository.model.User;
import com.symphony.hotelreview.service.converter.ServiceDTOConverter;
import com.symphony.hotelreview.service.converter.UserSignUpRequestConverter;
import com.symphony.hotelreview.service.converter.UserSignUpResponseConverter;
import com.symphony.hotelreview.service.dto.UserSignUpRequest;
import com.symphony.hotelreview.service.dto.UserSignUpResponse;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ServiceDTOConverter<UserSignUpRequest, User> serviceUserSignUpRequestConverter;
    private final ServiceDTOConverter<User, UserSignUpResponse> serviceUserSignUpResponseConverter;

    public UserServiceImpl(final UserRepository userRepository,
                           final UserSignUpRequestConverter serviceUserSignUpRequestConverter,
                           final UserSignUpResponseConverter serviceUserSignUpResponseConverter) {
        this.userRepository = userRepository;
        this.serviceUserSignUpRequestConverter = serviceUserSignUpRequestConverter;
        this.serviceUserSignUpResponseConverter = serviceUserSignUpResponseConverter;
    }

    @Override
    public UserSignUpResponse signUp(UserSignUpRequest userSignUpRequest) {
        final Optional<User> optionalUser = userRepository.findUserByEmail(userSignUpRequest.getEmail());

        optionalUser.ifPresent((user) -> new UserAlreadyExistsException("User with email " + user.getEmail() + " already exists."));

        final User user = serviceUserSignUpRequestConverter.convert(userSignUpRequest);
        final User savedUser =userRepository.save(user);
        return serviceUserSignUpResponseConverter.convert(savedUser);
    }
}
