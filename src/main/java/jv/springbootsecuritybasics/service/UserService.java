package jv.springbootsecuritybasics.service;

import jv.springbootsecuritybasics.dto.UserRegistrationRequest;
import jv.springbootsecuritybasics.dto.UserResponseDto;
import jv.springbootsecuritybasics.exception.RegistrationException;

public interface UserService {
    UserResponseDto register(UserRegistrationRequest request) throws RegistrationException;
}
