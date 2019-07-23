package com.circlee.bookbook.component.event;


import lombok.Data;

@Data
public class SearchKeywordEvent {
    private String keyword;

    private SearchKeywordEvent(String keyword){
        this.keyword = keyword;
    }

    public static SearchKeywordEvent of(String keyword) {
        return new SearchKeywordEvent(keyword);
    }
}
