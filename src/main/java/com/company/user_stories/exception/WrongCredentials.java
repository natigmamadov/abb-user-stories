package com.company.user_stories.exception;

public class WrongCredentials extends Exception{
    public WrongCredentials(String errorMessage){
        super(errorMessage);
    }
}
