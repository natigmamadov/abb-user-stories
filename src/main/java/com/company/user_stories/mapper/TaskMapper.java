package com.company.user_stories.mapper;

import com.company.user_stories.dao.dto.TaskDto;
import com.company.user_stories.dao.entity.Task;
import com.company.user_stories.model.request.CreateTaskRequest;

import java.time.LocalDateTime;


public enum TaskMapper {
    TASK_MAPPER;

    public Task mapCreateTaskRequestToTaskEntity(CreateTaskRequest request) {
        return Task.builder()
                .title(request.getTitle())
                .deadline(LocalDateTime.now().plusDays(7))
                .status(request.getStatus())
                .description(request.getDescription())
                .build();
    }

    public TaskDto mapTaskEntityToTaskDto(Task task) {
        return TaskDto.builder()
                .title(task.getTitle())
                .deadline(task.getDeadline())
                .status(task.getStatus())
                .description(task.getDescription())
                .build();
    }
}
