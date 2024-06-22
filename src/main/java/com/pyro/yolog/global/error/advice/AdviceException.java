package com.pyro.yolog.global.error.advice;

import com.pyro.yolog.global.jwt.exception.NotFoundTokenException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdviceException {
    @ExceptionHandler(NotFoundTokenException.class)
    public ResponseEntity<HttpEntity> notFoundTokenException() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
