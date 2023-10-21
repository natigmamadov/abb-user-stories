package com.company.user_stories.service;

import com.company.user_stories.error.WrongCredentials;
import com.company.user_stories.model.entity.Task;
import com.company.user_stories.model.entity.User;
import com.company.user_stories.model.request.CreateTaskRequest;
import com.company.user_stories.model.request.CreateUserRequest;
import com.company.user_stories.model.request.LoginRequest;
import com.company.user_stories.model.request.RegisterRequest;
import com.company.user_stories.model.response.OperationResponse;

import java.util.List;

public interface UserStoriesService {
    OperationResponse registerOrganization(RegisterRequest request);

    OperationResponse createUser(CreateUserRequest request);

    OperationResponse loginByPassword(LoginRequest request) throws WrongCredentials;

    List<User> getUsersByOrgId(Long id);

    List<Task> getAllTasks();

    Task createTask(CreateTaskRequest request);

    OperationResponse assignTask(Long taskId, Long userId);
}
