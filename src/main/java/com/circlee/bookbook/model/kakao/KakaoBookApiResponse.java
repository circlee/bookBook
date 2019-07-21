package com.circlee.bookbook.model.kakao;

import com.circlee.bookbook.model.kakao.common.Book;
import com.circlee.bookbook.model.kakao.common.Meta;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class KakaoBookApiResponse implements Serializable {

    private Meta meta;
    private List<Book> documents;
}
