package com.company.user_stories.controller;

import com.company.user_stories.dao.dto.TaskDto;
import com.company.user_stories.model.request.CreateTaskRequest;
import com.company.user_stories.service.TaskService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequestMapping("/v1/task")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/create")
    @ResponseStatus(CREATED)
    public void createTask(@RequestBody @Validated CreateTaskRequest request) {
        taskService.createTask(request);

    }

    @PatchMapping("/assign/{taskId}")
    @ResponseStatus(NO_CONTENT)
    public void assignTask(@PathVariable Long taskId, @RequestParam List<Long> userIds) {
        taskService.assignTask(taskId, userIds);
    }

    @GetMapping("/get-tasks")
    public List<TaskDto> getAllTasks() {
        return taskService.getAllTasks();
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(NO_CONTENT)
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }
}
