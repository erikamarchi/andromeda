package com.erikamarchi.andromeda.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler({
            ComandoInvalidoException.class,
            CoordenadaIndisponivelException.class,
            PousoException.class})
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public MensagemErro exceptionHandler(RuntimeException runtimeException) {
        return new MensagemErro(runtimeException.getMessage());
    }
}
