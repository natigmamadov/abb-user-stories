package com.company.user_stories.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AlreadyRegisteredException extends RuntimeException{
    private String code;

    public AlreadyRegisteredException(String message, String code) {
        super(message);
        this.code = code;
    }
}
