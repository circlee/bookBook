package com.circlee.bookbook.model.response;

import com.circlee.bookbook.model.kakao.common.Book;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
@Builder
public class BookItemRes implements Serializable {


    //제목, 도서 썸네일, 소개, ISBN, 저자, 출판사, 출판일, 정가, 판매가
    private String isbn;
    private String title;
    private String thumbnail;
    private String contents;
    private String authors;
    private String translators;
    private String publisher;
    @JsonSerialize(using= LocalDateSerializer.class)
    private LocalDate pubDate;
    private BigDecimal price;
    private BigDecimal salePrice;

    public static BookItemRes ofKakaoBook(Book kakaoBook) {
        return BookItemRes.builder()
                .isbn(kakaoBook.getIsbn())
                .title(kakaoBook.getTitle())
                .thumbnail(kakaoBook.getThumbnail())
                .contents(kakaoBook.getContents())
                .authors(Optional.ofNullable(kakaoBook.getAuthors()).map(list -> list.stream().collect(Collectors.joining())).orElse(", "))
                .translators(Optional.ofNullable(kakaoBook.getTranslators()).map(list -> list.stream().collect(Collectors.joining())).orElse(", "))
                .publisher(kakaoBook.getPublisher())
                .pubDate(kakaoBook.getDatetime())
                .price(kakaoBook.getPrice())
                .salePrice(kakaoBook.getSalePrice())
                .build();
    }


}
