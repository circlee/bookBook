package com.circlee.bookbook.model.kakao.common;

import lombok.Data;

import java.io.Serializable;

@Data
public class Meta implements Serializable {

    private Boolean isEnd;
    private Integer pageableCount;
    private Integer totalCount;
}
