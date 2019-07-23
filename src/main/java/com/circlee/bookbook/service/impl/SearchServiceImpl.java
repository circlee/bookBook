package com.circlee.bookbook.service.impl;

import com.circlee.bookbook.domain.search.SearchHistory;
import com.circlee.bookbook.domain.search.SearchKeyword;
import com.circlee.bookbook.model.response.KeywordHistoryRes;
import com.circlee.bookbook.model.response.KeywordRes;
import com.circlee.bookbook.repository.search.SearchHistoryRespository;
import com.circlee.bookbook.repository.search.SearchKeywordRespository;
import com.circlee.bookbook.service.SearchService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Slf4j
@Service
@RequiredArgsConstructor
public class SearchServiceImpl implements SearchService {

    private final SearchHistoryRespository searchHistoryRespository;
    private final SearchKeywordRespository searchKeywordRespository;

    @Override
    @Transactional
    public void saveSearchHistory(String keyword) {

        log.debug("saveSearchHistory : {}", keyword);
        searchHistoryRespository.save(SearchHistory.of(keyword));

        SearchKeyword searchKeyword = searchKeywordRespository.findTopByKeyword(keyword);
        if(searchKeyword == null) {
            searchKeyword = searchKeywordRespository.save(SearchKeyword.of(keyword));
        }
        searchKeywordRespository.updateSearchKeywordCount(searchKeyword);
    }

    @Override
    public List<KeywordRes> getKeywords() {
        return searchKeywordRespository.findTop10ByOrderByCountDescIdDesc().stream()
                .map(k -> KeywordRes.of(k.getKeyword(), k.getCount()))
                .collect(Collectors.toList());
    }

    @Override
    public List<KeywordHistoryRes> getKeywordHistories(Long id) {
        return searchHistoryRespository.findByCreatedByOrderByCreatedAtDesc(id).stream()
                .map(k -> KeywordHistoryRes.of(k.getKeyword(), k.getCreatedAt()))
                .collect(Collectors.toList());
    }
}
