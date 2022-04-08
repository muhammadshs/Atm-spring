package com.dwteam.atm.exception;

import org.springframework.http.HttpStatus;

public class NotFindException extends BaseException{
    private String message,className;

    public NotFindException(String message, String className) {
        this.message = message;
        this.className = className;
    }

    @Override
    public ExpDTO mainExp() {
        return new ExpDTO(message, HttpStatus.NOT_FOUND,className);
    }


}
