package com.circlee.bookbook.model.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class BaseRes implements Serializable {


    private String message;

    public BaseRes() {}

    private BaseRes(String message) {
        this.message = message;
    }

    public static BaseRes of(String message) {
        return new BaseRes(message);
    }

}
