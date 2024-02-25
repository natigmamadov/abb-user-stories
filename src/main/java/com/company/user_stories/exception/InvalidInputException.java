package com.company.user_stories.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class InvalidInputException extends RuntimeException{
    private String code;

    public InvalidInputException(String message, String code) {
        super(message);
        this.code = code;
    }
}
