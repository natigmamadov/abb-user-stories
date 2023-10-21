package com.company.user_stories.error;

public class AlreadyRegisteredUsernameException extends RuntimeException{
    public AlreadyRegisteredUsernameException(String errorMessage){
        super(errorMessage);
    }

}
