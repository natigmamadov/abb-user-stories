package com.company.user_stories.controller;

import com.company.user_stories.dao.dto.UserDto;
import com.company.user_stories.model.request.CreateUserRequest;
import com.company.user_stories.service.UserService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/v1/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create-user")
    @ResponseStatus(CREATED)
    public void createUser(@RequestBody @Validated CreateUserRequest request) {
        userService.createUser(request);
    }

    @GetMapping("/get-users/{organizationId}")
    public List<UserDto> getUsersByOrgOid(@PathVariable Long organizationId){
        return userService.getUsersByOrgId(organizationId);
    }
}
