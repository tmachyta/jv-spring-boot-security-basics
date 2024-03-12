package jv.springbootsecuritybasics.service;

import jv.springbootsecuritybasics.dto.UserRegistrationRequest;
import jv.springbootsecuritybasics.dto.UserResponseDto;
import jv.springbootsecuritybasics.exception.RegistrationException;
import jv.springbootsecuritybasics.mapper.UserMapper;
import jv.springbootsecuritybasics.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserResponseDto register(UserRegistrationRequest request)
            throws RegistrationException {
        if (userRepository.findbyEmail(request.getEmail()).isPresent()) {
            throw new RegistrationException("Unable to complete registration");
        }

        if (!request.getPassword().equals(request.getRepeatPassword())) {
            throw new RegistrationException("Passwords do not match");
        }

        return userMapper.toDto(userRepository.save(userMapper.toModel(request)));
    }
}
