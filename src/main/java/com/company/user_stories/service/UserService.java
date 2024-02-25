package com.company.user_stories.service;

import com.company.user_stories.dao.dto.UserDto;
import com.company.user_stories.model.request.CreateUserRequest;

import java.util.List;

public interface UserService {
    void createUser(CreateUserRequest request);
    List<UserDto> getUsersByOrgId(Long organizationId);
}
