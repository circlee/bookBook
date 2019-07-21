package com.circlee.bookbook.model.kakao.common;

import com.circlee.bookbook.util.jackson.LocalDateTimeDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class Book implements Serializable {

    //제목, 도서 썸네일, 소개, ISBN, 저자, 출판사, 출판일, 정가, 판매가
    private String title;
    private String thumbnail;
    private String contents;
    private String isbn;
    private List<String> authors;
    private List<String> translators;
    private String publisher;
    private String url;
    private String status;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime datetime;

    private BigDecimal price;
    private BigDecimal salePrice;

}
