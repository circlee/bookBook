package com.circlee.bookbook.model.naver.common;

import com.circlee.bookbook.util.jackson.LocalDateYmdDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class Book implements Serializable {

    private String title;
    private String link;
    private String author;
    private BigDecimal price;
    private BigDecimal discount;
    private String publisher;
    private String isbn;
    private String image;
    private String description;
    @JsonDeserialize(using = LocalDateYmdDeserializer.class)
    private LocalDate pubdate;
}
