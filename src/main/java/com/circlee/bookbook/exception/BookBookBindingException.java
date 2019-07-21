package com.circlee.bookbook.exception;

import com.circlee.bookbook.model.response.BaseRes;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;

public class BookBookBindingException extends BookBookException {

    private BindingResult bindingResult;

    public BookBookBindingException(BindingResult bindingResult) {
        super(HttpStatus.BAD_REQUEST, "잘못된 요청입니다.");
        this.bindingResult = bindingResult;
    }

    public BaseRes toBaseRes(){
        String errorMessage = this.bindingResult.getAllErrors().stream()
                .map(error -> error.getDefaultMessage())
                .findFirst()
                .orElse("");
        return BaseRes.of(errorMessage);
    }
}
