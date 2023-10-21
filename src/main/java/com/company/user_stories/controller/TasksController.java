package com.company.user_stories.controller;

import com.company.user_stories.model.entity.Task;
import com.company.user_stories.model.request.CreateTaskRequest;
import com.company.user_stories.model.response.OperationResponse;
import com.company.user_stories.service.UserStoriesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/public/t1")
public class TasksController {
    private final UserStoriesService userStoriesService;

    public TasksController(UserStoriesService userStoriesService) {
        this.userStoriesService = userStoriesService;
    }

    @PostMapping("/create-task")
    public ResponseEntity<Task> createTask(@RequestBody @Validated CreateTaskRequest request){
        Task response = userStoriesService.createTask(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/assign-task/{taskId}/{userId}")
    public ResponseEntity<OperationResponse> assignTask(@PathVariable(name = "taskId") Long taskId,@PathVariable(name = "userId") Long userId){
        OperationResponse response = userStoriesService.assignTask(taskId,userId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/get-all-tasks")
    public ResponseEntity<List<Task>> getAllTasks(){
        List<Task> allTasks = userStoriesService.getAllTasks();
        return new ResponseEntity<>(allTasks, HttpStatus.OK);
    }
}
