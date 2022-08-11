package com.erikamarchi.andromeda.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;


public class ComandoInvalidoException extends RuntimeException {


    public ComandoInvalidoException(String message) {
        super(message);
    }
}
