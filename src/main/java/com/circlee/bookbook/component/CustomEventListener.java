package com.circlee.bookbook.component;

import com.circlee.bookbook.component.event.SearchKeywordEvent;
import com.circlee.bookbook.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomEventListener {

    private final SearchService searchService;

    @Async
    @EventListener
    public void handle(SearchKeywordEvent searchKeywordEvent) {
        searchService.saveSearchHistory(searchKeywordEvent.getKeyword());
    }


}
