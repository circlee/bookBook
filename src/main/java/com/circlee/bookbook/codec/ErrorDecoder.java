package com.circlee.bookbook.codec;

import com.circlee.bookbook.exception.BookBookException;
import feign.Response;
import org.springframework.http.HttpStatus;

public class ErrorDecoder implements feign.codec.ErrorDecoder {
    @Override
    public Exception decode(String methodKey, Response response) {
        return new BookBookException(HttpStatus.valueOf(response.status()), "Feign client Error");
    }
}
