package com.circlee.bookbook.model.response;

import lombok.Data;

import java.util.List;

@Data
public class ListRes<T> extends BaseRes  {
    private List<T> items;

    private ListRes(List<T> items) {
        this.items = items;
    }

    public static <T> ListRes<T> of(List<T> items) {
        return new ListRes<>(items);
    }

}
