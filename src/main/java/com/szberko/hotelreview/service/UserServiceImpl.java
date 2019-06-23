package com.szberko.hotelreview.service;

import com.szberko.hotelreview.exceptions.UserAlreadyExistsException;
import com.szberko.hotelreview.repository.UserRepository;
import com.szberko.hotelreview.repository.model.User;
import com.szberko.hotelreview.service.converter.ServiceDTOConverter;
import com.szberko.hotelreview.service.converter.UserSignUpRequestConverter;
import com.szberko.hotelreview.service.converter.UserSignUpResponseConverter;
import com.szberko.hotelreview.service.dto.UserSignUpRequest;
import com.szberko.hotelreview.service.dto.UserSignUpResponse;
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
