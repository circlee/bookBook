package com.circlee.bookbook.service;

import com.circlee.bookbook.model.response.KeywordHistoryRes;
import com.circlee.bookbook.model.response.KeywordRes;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface SearchService {
    @Transactional
    void saveSearchHistory(String keyword);

    List<KeywordRes> getKeywords();

    List<KeywordHistoryRes> getKeywordHistories(Long id);
}
