package com.company.user_stories.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class NotFoundException extends RuntimeException{
    private String code;

    public NotFoundException(String message, String code) {
        super(message);
        this.code = code;
    }
}
