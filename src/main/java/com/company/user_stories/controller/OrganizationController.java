package com.company.user_stories.controller;

import com.company.user_stories.model.request.LoginRequest;
import com.company.user_stories.model.request.RegisterRequest;
import com.company.user_stories.service.OrganizationService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequestMapping("/v1/organization")
public class OrganizationController {

    private final OrganizationService service;

    public OrganizationController(OrganizationService service) {
        this.service = service;
    }

    @PostMapping("/register-organization")
    @ResponseStatus(CREATED)
    public void registerOrganization(@RequestBody @Validated RegisterRequest request){
       service.registerOrganization(request);
    }

    @PostMapping("/login")
    @ResponseStatus(NO_CONTENT)
    public void loginByUsernameAndPassword (@RequestBody @Validated LoginRequest request){
        service.loginByUsernameAndPassword(request);

    }
}
