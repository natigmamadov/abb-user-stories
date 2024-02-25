package com.company.user_stories.service.impl;

import com.company.user_stories.dao.dto.UserDto;
import com.company.user_stories.exception.AlreadyCreatedException;
import com.company.user_stories.exception.NotFoundException;
import com.company.user_stories.model.request.CreateUserRequest;
import com.company.user_stories.repository.UserRepository;
import com.company.user_stories.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static com.company.user_stories.exception.ExceptionConstants.*;
import static com.company.user_stories.mapper.UserMapper.USER_MAPPER;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void createUser(CreateUserRequest request) {
        String email = request.getEmail();
        var user = userRepository.findByEmail(email);
        if (Objects.nonNull(user)) {
            throw new AlreadyCreatedException(String.format(EMAIL_ALREADY_CREATED_MESSAGE, email),
                                                            EMAIL_ALREADY_CREATED_CODE);
        }

        userRepository.save(USER_MAPPER.createUserRequestToUserEntity(request));

    }

    @Override
    public List<UserDto> getUsersByOrgId(Long organizationId) {
       var users = userRepository.findByOrganizationId(organizationId);
        if (users.isEmpty()) {
            throw new NotFoundException(USER_NOT_FOUND_MESSAGE,
                                        USER_NOT_FOUND_CODE);
        }
        return users.stream()
                .map(USER_MAPPER::mapUserEntityToUserDto)
                .collect(Collectors.toList());
    }

    public static String getFirstThreeLetter(String userInformation) {
        return userInformation.substring(0, 3);
    }
}
