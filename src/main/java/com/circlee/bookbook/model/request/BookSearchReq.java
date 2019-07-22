package com.circlee.bookbook.model.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
public class BookSearchReq implements Serializable {
    private int pageNo = 1;
    private int limit = 10;

    @NotBlank(message = "검색어를 입력해야합니다.")
    private String keyword;
}
