package com.company.user_stories.mapper;

import com.company.user_stories.dao.entity.Organization;

import com.company.user_stories.model.request.CreateUserRequest;
import com.company.user_stories.model.request.RegisterRequest;

import static com.company.user_stories.util.PasswordEncrypter.encryptPassword;


public enum OrganizationMapper {
    ORGANIZATION_MAPPER;

    public Organization createUserRequestToOrganizationEntity(CreateUserRequest createUserRequest) {
        return Organization.builder()
                .id(createUserRequest.getOrganizationId())
                .build();
    }

    public Organization registerRequestToOrganizationEntity(RegisterRequest registerRequest){
        return Organization.builder()
                .organizationName(registerRequest.getOrganizationName())
                .phoneNumber(registerRequest.getPhoneNumber())
                .userName(registerRequest.getUserName())
                .password(encryptPassword(registerRequest.getPassword()))
                .address(registerRequest.getAddress())
                .email(registerRequest.getEmail())
                .build();
    }
}