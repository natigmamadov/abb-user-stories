package com.company.user_stories.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.company.user_stories.exception.ExceptionConstants.UNEXPECTED_EXCEPTION_CODE;
import static com.company.user_stories.exception.ExceptionConstants.UNEXPECTED_EXCEPTION_MESSAGE;
import static org.springframework.http.HttpStatus.*;

@RestControllerAdvice
@Slf4j
public class ErrorHandler {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(INTERNAL_SERVER_ERROR)
    public ExceptionResponse handle(Exception ex) {
        log.error("Exception: ", ex);
        return new ExceptionResponse(UNEXPECTED_EXCEPTION_CODE,
                UNEXPECTED_EXCEPTION_MESSAGE);
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(NOT_FOUND)
    public ExceptionResponse handle(NotFoundException ex) {
        log.error("NotFoundException: ", ex);
        return new ExceptionResponse(ex.getCode(), ex.getMessage());
    }

    @ExceptionHandler(AlreadyCreatedException.class)
    @ResponseStatus(BAD_REQUEST)
    public ExceptionResponse handle(AlreadyCreatedException ex) {
        log.error("AlreadyCreatedException: ", ex);
        return new ExceptionResponse(ex.getCode(), ex.getMessage());
    }

    @ExceptionHandler(AlreadyRegisteredException.class)
    @ResponseStatus(BAD_REQUEST)
    public ExceptionResponse handle(AlreadyRegisteredException ex) {
        log.error("AlreadyRegisteredException: ", ex);
        return new ExceptionResponse(ex.getCode(), ex.getMessage());
    }

    @ExceptionHandler(InvalidInputException.class)
    @ResponseStatus(BAD_REQUEST)
    public ExceptionResponse handle(InvalidInputException ex) {
        log.error("InvalidInputException: ", ex);
        return new ExceptionResponse(ex.getCode(), ex.getMessage());
    }
}
