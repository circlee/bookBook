package com.circlee.bookbook.model.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class KeywordRes implements Serializable {
    private String keyword;
    private Long count;

    private KeywordRes (String keyword, Long count) {
        this.keyword = keyword;
        this.count = count;
    }

    public static KeywordRes of(String keyword, Long count){
        return new KeywordRes(keyword, count);
    }

}
