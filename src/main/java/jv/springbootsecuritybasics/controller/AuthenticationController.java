package jv.springbootsecuritybasics.controller;

import jv.springbootsecuritybasics.dto.UserLoginRequestDto;
import jv.springbootsecuritybasics.dto.UserLoginResponseDto;
import jv.springbootsecuritybasics.dto.UserRegistrationRequest;
import jv.springbootsecuritybasics.dto.UserResponseDto;
import jv.springbootsecuritybasics.exception.RegistrationException;
import jv.springbootsecuritybasics.security.AuthenticationService;
import jv.springbootsecuritybasics.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthenticationController {
    private final UserService userService;
    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public UserResponseDto register(UserRegistrationRequest request)
            throws RegistrationException {
        return userService.register(request);
    }

    @PostMapping("/login")
    public UserLoginResponseDto login(@RequestBody UserLoginRequestDto requestDto) {
        return authenticationService.authenticate(requestDto);
    }
}
