package com.infinity.co.exception;

import org.springframework.http.HttpStatus;

public class CompanyException extends RuntimeException{

    private HttpStatus httpStatus;


    private static final long serialVersionUID = -8070293882247788876L;

    public CompanyException() {
    }

    public CompanyException(String message, HttpStatus httpStatus) {
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
