package jv.springbootsecuritybasics.mapper;

import jv.springbootsecuritybasics.config.MapperConfig;
import jv.springbootsecuritybasics.dto.UserRegistrationRequest;
import jv.springbootsecuritybasics.dto.UserResponseDto;
import jv.springbootsecuritybasics.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapperConfig.class)
public interface UserMapper {
    UserResponseDto toDto(User user);

    @Mapping(target = "id", ignore = true)
    User toModel(UserRegistrationRequest request);
}
