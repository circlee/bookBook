package com.circlee.bookbook.controller.api;

import com.circlee.bookbook.model.auth.CustomUserDetail;
import com.circlee.bookbook.model.response.KeywordHistoryRes;
import com.circlee.bookbook.model.response.KeywordRes;
import com.circlee.bookbook.model.response.ListRes;
import com.circlee.bookbook.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/search")
public class SearchController {


    private final SearchService searchService;

    @GetMapping("/keywords")
    public ListRes<KeywordRes> getKewords(){
        return ListRes.of(searchService.getKeywords());
    }

    @GetMapping("/my/keywords")
    public ListRes<KeywordHistoryRes> getMyKeywordHistories(@AuthenticationPrincipal CustomUserDetail customUserDetail){

        return ListRes.of(searchService.getKeywordHistories(customUserDetail.getId()));
    }

}
