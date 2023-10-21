package com.company.user_stories.error;

public class ValidateInputParamException extends RuntimeException{
    public ValidateInputParamException(String errorMessage){
        super(errorMessage);
    }
}
