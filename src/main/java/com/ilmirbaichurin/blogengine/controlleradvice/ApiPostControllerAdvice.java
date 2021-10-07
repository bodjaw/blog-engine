package com.ilmirbaichurin.blogengine.controlleradvice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ApiPostControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    IllegalPostRequestArgumentExceptionDTO onMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        return new IllegalPostRequestArgumentExceptionDTO(e.getMessage());
    }

    private static class IllegalPostRequestArgumentExceptionDTO {
        private final String message;

        public IllegalPostRequestArgumentExceptionDTO(String message) {
            this.message = message;
        }
    }
}