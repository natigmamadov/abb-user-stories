package com.company.user_stories.mapper;

import com.company.user_stories.dao.dto.UserDto;
import com.company.user_stories.dao.entity.User;
import com.company.user_stories.model.request.CreateUserRequest;

import static com.company.user_stories.mapper.OrganizationMapper.ORGANIZATION_MAPPER;
import static com.company.user_stories.service.impl.UserServiceImpl.getFirstThreeLetter;

public enum UserMapper {
    USER_MAPPER;

    public User createUserRequestToUserEntity(CreateUserRequest createUserRequest) {
        return User.builder()
                .name(createUserRequest.getName())
                .surname(createUserRequest.getSurname())
                .email(createUserRequest.getEmail())
                .defaultPassword(getFirstThreeLetter(createUserRequest.getName()) +
                        getFirstThreeLetter(createUserRequest.getSurname()) + "123")
                .organization(ORGANIZATION_MAPPER.createUserRequestToOrganizationEntity(createUserRequest))
                .build();
    }

    public UserDto mapUserEntityToUserDto(User user){
        return UserDto.builder()
                .name(user.getName())
                .surname(user.getSurname())
                .email(user.getEmail())
                .defaultPassword(user.getDefaultPassword())
                .build();

    }
}
