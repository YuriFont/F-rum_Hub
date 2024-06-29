package com.yurifont.forum_hub.infra.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity tratarErrorRegraDeNegocio(ValidationException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

}
