package com.company.user_stories.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AlreadyCreatedException extends RuntimeException{
    private String code;

    public AlreadyCreatedException(String message, String code) {
        super(message);
        this.code = code;
    }
}
