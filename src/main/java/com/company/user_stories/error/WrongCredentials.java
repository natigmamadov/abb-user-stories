package com.company.user_stories.error;

public class WrongCredentials extends Exception{
    public WrongCredentials(String errorMessage){
        super(errorMessage);
    }
}
