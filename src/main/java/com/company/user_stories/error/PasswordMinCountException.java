package com.company.user_stories.error;

public class PasswordMinCountException extends RuntimeException{
    public PasswordMinCountException(String errorMessage){
        super(errorMessage);
    }

}
