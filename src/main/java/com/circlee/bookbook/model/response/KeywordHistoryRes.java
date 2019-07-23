package com.circlee.bookbook.model.response;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class KeywordHistoryRes implements Serializable {
    private String keyword;

    @JsonSerialize(using= LocalDateTimeSerializer.class)
    private LocalDateTime createdAt;

    private KeywordHistoryRes(String keyword, LocalDateTime createdAt) {
        this.keyword = keyword;
        this.createdAt = createdAt;
    }

    public static KeywordHistoryRes of(String keyword, LocalDateTime createdAt){
        return new KeywordHistoryRes(keyword, createdAt);
    }

}
