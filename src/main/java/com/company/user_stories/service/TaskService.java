package com.company.user_stories.service;

import com.company.user_stories.dao.dto.TaskDto;
import com.company.user_stories.model.request.CreateTaskRequest;

import java.util.List;

public interface TaskService {
    void createTask(CreateTaskRequest request);

    void assignTask(Long taskId, List<Long> userIds);

    List<TaskDto> getAllTasks();

    void deleteTask(Long id);
}
