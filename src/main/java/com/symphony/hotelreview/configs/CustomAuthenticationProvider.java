//package com.symphony.hotelreview.configs;
//
//import com.symphony.hotelreview.repository.UserRepository;
//import com.symphony.hotelreview.repository.model.User;
//import com.symphony.hotelreview.service.UserService;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//@Component
//public class CustomAuthenticationProvider implements AuthenticationProvider {
//
//    private final UserRepository userRepository;
//
//    public CustomAuthenticationProvider(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    @Override
//    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//        String email = authentication.getName();
//        String password = authentication.getCredentials().toString();
//
//        Optional<User> optionalUser = userRepository.findUserByEmail(email);
//        List<GrantedAuthority> authorities = new ArrayList<>();
//        optionalUser.ifPresent(user -> authorities.add(new SimpleGrantedAuthority("ADMIN")));
//
//        return new UsernamePasswordAuthenticationToken(email, password, authorities);
//    }
//
//    @Override
//    public boolean supports(Class<?> authentication) {
//        return authentication.equals(UsernamePasswordAuthenticationToken.class);
//    }
//}
