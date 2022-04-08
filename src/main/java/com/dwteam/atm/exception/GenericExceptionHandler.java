package com.dwteam.atm.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GenericExceptionHandler {

    @ExceptionHandler(value = BaseException.class)
    public ResponseEntity<?> baseExpHandler(BaseException baseException){
        return new ResponseEntity<>(baseException.mainExp(),baseException.mainExp().getHttpStatus());
    }
}
