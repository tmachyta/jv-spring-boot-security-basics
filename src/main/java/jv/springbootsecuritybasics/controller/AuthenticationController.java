package jv.springbootsecuritybasics.controller;

import jv.springbootsecuritybasics.dto.UserRegistrationRequest;
import jv.springbootsecuritybasics.dto.UserResponseDto;
import jv.springbootsecuritybasics.exception.RegistrationException;
import jv.springbootsecuritybasics.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthenticationController {
    private final UserService userService;

    public UserResponseDto register(UserRegistrationRequest request)
            throws RegistrationException {
        return userService.register(request);
    }
}
