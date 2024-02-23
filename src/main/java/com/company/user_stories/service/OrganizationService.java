package com.company.user_stories.service;

import com.company.user_stories.model.request.LoginRequest;
import com.company.user_stories.model.request.RegisterRequest;

public interface OrganizationService {
    void registerOrganization(RegisterRequest request);

    void loginByUsernameAndPassword(LoginRequest request);
}
