package com.company.user_stories.exception;

public interface ExceptionConstants {
    String UNEXPECTED_EXCEPTION_CODE = "UNEXPECTED_EXCEPTION";
    String UNEXPECTED_EXCEPTION_MESSAGE = "Unexpected exception occurred";

    String ORGANIZATION_NOT_FOUND_CODE = "ORGANIZATION_NOT_FOUND";
    String ORGANIZATION_NOT_FOUND_MESSAGE = "Organization with username:%s is not found";

    String USER_NOT_FOUND_CODE = "USER_NOT_FOUND";
    String USER_NOT_FOUND_MESSAGE = "User not found";

    String TASK_NOT_FOUND_CODE = "TASK_NOT_FOUND";
    String TASK_NOT_FOUND_MESSAGE = "Task with id:%s is not found";

    String  EMAIL_ALREADY_CREATED_CODE = "EMAIL_ALREADY_CREATED";
    String  EMAIL_ALREADY_CREATED_MESSAGE = "User is already created with email:%s ";

    String  EMAIL_OR_USERNAME_ALREADY_REGISTERED_CODE = "EMAIL_OR_USERNAME_ALREADY_REGISTERED";
    String  EMAIL_OR_USERNAME_ALREADY_REGISTERED_MESSAGE = "Organization with username:%s and email:%s is already registered";

    String  USERNAME_OR_PASSWORD_IS_EMPTY_CODE = "USERNAME_OR_PASSWORD_IS_EMPTY";
    String  USERNAME_OR_PASSWORD_IS_EMPTY_MESSAGE = "UserName or password is empty";

    String  PASSWORD_LENGTH_IS_LESS_THAN_SIX_CODE = "PASSWORD_LENGTH_IS_LESS_THAN_SIX";
    String  PASSWORD_LENGTH_IS_LESS_THAN_SIX_MESSAGE = "Password length is less than 6";
}
