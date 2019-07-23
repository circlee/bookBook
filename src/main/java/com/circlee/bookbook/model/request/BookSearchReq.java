package com.circlee.bookbook.model.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
public class BookSearchReq implements Serializable {
    private int pageNo = 1;
    private int limit = 10;

    @NotBlank(message = "검색어를 입력해야합니다.")
    @Size(max=20,message = "검색어는 최대 20자를 넘을수 없습니다.")
    private String keyword;
}
