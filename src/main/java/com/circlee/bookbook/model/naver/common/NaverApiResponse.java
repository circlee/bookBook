package com.circlee.bookbook.model.naver.common;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class NaverApiResponse<T> implements Serializable {

    private String lastBuildDate;
    private Integer total;
    private Integer start;
    private Integer display;
    private List<T> items;
}
