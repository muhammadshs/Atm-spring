package com.dwteam.atm.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;
@Data
public class ExpDTO {
    private String massage;
    private HttpStatus httpStatus;
    private String className;

    public ExpDTO(String massage, HttpStatus httpStatus, String className) {
        this.massage = massage;
        this.httpStatus = httpStatus;
        this.className = className;
    }
}
