package com.circlee.bookbook.advice;

import com.circlee.bookbook.exception.BookBookException;
import com.circlee.bookbook.model.response.BaseRes;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionAdvice {


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BookBookException.class)
    public BaseRes handle(BookBookException exception) {
        return exception.toBaseRes();
    }

}
