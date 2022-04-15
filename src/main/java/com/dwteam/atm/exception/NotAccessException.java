package com.dwteam.atm.exception;

import com.dwteam.atm.base.BaseEntity;
import org.springframework.http.HttpStatus;

public class NotAccessException extends BaseException {
    private String message,className;

    public NotAccessException(String message, String className) {
        this.message = message;
        this.className = className;
    }

    @Override
    public ExpDTO mainExp() {
        return new ExpDTO(message, HttpStatus.FORBIDDEN,className);
    }
}
