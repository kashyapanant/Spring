package com.infinity.co.exception;

import org.springframework.http.HttpStatus;

public class OwnerException extends RuntimeException{


    private static final long serialVersionUID = 8219954105243181140L;

    private HttpStatus httpStatus;

    public OwnerException() {
    }

    public OwnerException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus=httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }
}
