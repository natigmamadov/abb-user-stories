package com.company.user_stories.error;

public class AlreadyCreatedException extends RuntimeException{
    public AlreadyCreatedException(String errorMessage){
        super(errorMessage);
    }

}
