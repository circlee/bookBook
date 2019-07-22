package com.circlee.bookbook.model.response;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class PageableRes<T> implements Serializable {
    private int totalCount;
    private int limit;
    private List<T> items;
}
