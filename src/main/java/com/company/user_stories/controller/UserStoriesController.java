package com.company.user_stories.controller;

import com.company.user_stories.error.WrongCredentials;
import com.company.user_stories.model.entity.User;
import com.company.user_stories.model.request.CreateUserRequest;
import com.company.user_stories.model.request.LoginRequest;
import com.company.user_stories.model.request.RegisterRequest;
import com.company.user_stories.model.response.OperationResponse;
import com.company.user_stories.service.UserStoriesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/public/v1")
public class UserStoriesController {

    private final UserStoriesService userStoriesService;

    public UserStoriesController(UserStoriesService userStoriesService) {
        this.userStoriesService = userStoriesService;
    }

    @PostMapping("/register-organization")
    public ResponseEntity<OperationResponse> registerOrganization(@RequestBody @Validated RegisterRequest request){
        OperationResponse response = userStoriesService.registerOrganization(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/create-user")
    public ResponseEntity<OperationResponse> createUser(@RequestBody @Validated CreateUserRequest request){
        OperationResponse response = userStoriesService.createUser(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<OperationResponse> loginByPassword (@RequestBody @Validated LoginRequest request) throws WrongCredentials {
        OperationResponse response = userStoriesService.loginByPassword(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/get-users/{id}")
    public List<User> getUsersByOrgOid(@PathVariable Long organizationId){
        return userStoriesService.getUsersByOrgId(organizationId);
    }


}
