package com.dwteam.atm.exception;

import org.springframework.http.HttpStatus;

public class DuplicateException extends BaseException{
    String message,clazzName;

    public DuplicateException(String message, String clazzName) {
        this.message = message;
        this.clazzName = clazzName;
    }

    @Override
    public ExpDTO mainExp() {
        return new ExpDTO(message, HttpStatus.CONFLICT,clazzName);
    }
}
