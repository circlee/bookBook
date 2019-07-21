package com.circlee.bookbook.exception;

import com.circlee.bookbook.model.response.BaseRes;
import org.springframework.http.HttpStatus;

public class BookBookException extends RuntimeException {

    private HttpStatus httpStatus;
    private String message;
    public BookBookException(HttpStatus httpStatus, String message) {
        super(message);
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public BaseRes toBaseRes(){
        return BaseRes.of(this.message);
    }
}
