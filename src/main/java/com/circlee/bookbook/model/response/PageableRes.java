package com.circlee.bookbook.model.response;

import lombok.Data;

import java.util.List;

@Data
public class PageableRes<T> extends BaseRes {
    private int totalCount;
    private int limit;
    private List<T> items;
}
