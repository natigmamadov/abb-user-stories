package com.company.user_stories.service.impl;

import com.company.user_stories.exception.*;
import com.company.user_stories.model.request.LoginRequest;
import com.company.user_stories.model.request.RegisterRequest;
import com.company.user_stories.repository.OrganizationRepository;
import com.company.user_stories.service.OrganizationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static com.company.user_stories.exception.ExceptionConstants.*;
import static com.company.user_stories.mapper.OrganizationMapper.ORGANIZATION_MAPPER;

@Service
@Slf4j
public class OrganizationServiceImpl implements OrganizationService {

    private final OrganizationRepository organizationRepository;

    public OrganizationServiceImpl(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    @Override
    public void registerOrganization(RegisterRequest request) {
        String userName = request.getUserName();
        String email = request.getEmail();
        String password = request.getPassword();

        validatePasswordLength(password);

        var organization = organizationRepository.findByUserNameAndEmail(userName, email);
        if (Objects.nonNull(organization)) {
            throw new AlreadyRegisteredException(String.format(
                    EMAIL_OR_USERNAME_ALREADY_REGISTERED_MESSAGE, userName, email),
                    EMAIL_OR_USERNAME_ALREADY_REGISTERED_CODE);
        }
        organizationRepository.save(ORGANIZATION_MAPPER.
                                    registerRequestToOrganizationEntity(request));
    }

    @Override
    public void loginByUsernameAndPassword(LoginRequest request) {
        String userName = request.getUserName();
        String password = request.getPassword();

        validateUserNameAndPassword(userName,password);

        var organization = organizationRepository.findByUserNameAndPassword(userName, password);

        if (Objects.isNull(organization)) {
            throw new NotFoundException(String.format(
                    ORGANIZATION_NOT_FOUND_MESSAGE, userName),
                    ORGANIZATION_NOT_FOUND_CODE);
        }
    }

    private void validateUserNameAndPassword(String userName,String password){
        if (Objects.isNull(userName) ||userName.trim().isEmpty()
                || Objects.isNull(password) || password.trim().isEmpty()) {
            throw new InvalidInputException(USERNAME_OR_PASSWORD_IS_EMPTY_MESSAGE,
                    USERNAME_OR_PASSWORD_IS_EMPTY_CODE);
        }
    }

    private void validatePasswordLength(String password){
        if (password.trim().length() < 6) {
            throw new InvalidInputException(PASSWORD_LENGTH_IS_LESS_THAN_SIX_MESSAGE,
                    PASSWORD_LENGTH_IS_LESS_THAN_SIX_CODE);
        }
    }
}
