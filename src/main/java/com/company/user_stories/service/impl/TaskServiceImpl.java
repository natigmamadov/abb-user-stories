package com.company.user_stories.service.impl;


import com.company.user_stories.dao.dto.TaskDto;
import com.company.user_stories.dao.entity.Task;
import com.company.user_stories.dao.entity.User;
import com.company.user_stories.exception.NotFoundException;
import com.company.user_stories.model.request.CreateTaskRequest;
import com.company.user_stories.repository.TaskRepository;
import com.company.user_stories.repository.UserRepository;
import com.company.user_stories.service.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.stream.Collectors;

import static com.company.user_stories.exception.ExceptionConstants.*;
import static com.company.user_stories.mapper.TaskMapper.TASK_MAPPER;
import static com.company.user_stories.model.enums.TaskStatus.DELETED;

@Slf4j
@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;


    public TaskServiceImpl(TaskRepository taskRepository, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void createTask(CreateTaskRequest request) {
        taskRepository.save(TASK_MAPPER.mapCreateTaskRequestToTaskEntity(request));
    }

    @Override
    @Transactional
    public void assignTask(Long taskId, List<Long> userIds) {
        taskRepository.findById(taskId)
                .ifPresent(presentTask -> {
                    List<User> users = userRepository.findAllById(userIds);
                    if (users.isEmpty()) {
                        throw new NotFoundException(USER_NOT_FOUND_MESSAGE, USER_NOT_FOUND_CODE);
                    }
                    presentTask.getUsers().addAll(users);
                    taskRepository.save(presentTask);
                });
    }

    @Override
    public List<TaskDto> getAllTasks() {
        List<Task> tasks = taskRepository.findAll();
        return tasks.stream()
                .map(TASK_MAPPER::mapTaskEntityToTaskDto)
                .collect(Collectors.toList());

    }

    @Override
    public void deleteTask(Long id) {
        var task = fetchTaskIfExists(id);
        task.setStatus(DELETED);
        taskRepository.save(task);

    }

    private Task fetchTaskIfExists(Long id) {
        return taskRepository.findByIdAndStatusNot(id, DELETED)
                .orElseThrow(() -> {
                    throw new NotFoundException(String.format(TASK_NOT_FOUND_MESSAGE, id),
                            TASK_NOT_FOUND_CODE);
                });
    }
}
