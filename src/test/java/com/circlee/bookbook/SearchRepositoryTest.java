package com.circlee.bookbook;


import com.circlee.bookbook.domain.search.SearchHistory;
import com.circlee.bookbook.domain.search.SearchKeyword;
import com.circlee.bookbook.repository.search.SearchHistoryRespository;
import com.circlee.bookbook.repository.search.SearchKeywordRespository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SearchRepositoryTest {
    @Autowired
    SearchKeywordRespository searchKeywordRespository;

    @Autowired
    SearchHistoryRespository searchHistoryRespository;

    public static final String TEST_KEYWORD = "테스트";
    public static final String TEST_KEYWORD2 = "테스트2";
    public static final Long USER_ID = 1L;
    @Test
    public void saveSearchKeyword() {
        searchKeywordRespository.save(SearchKeyword.of(TEST_KEYWORD));
        Assert.assertNotNull(searchKeywordRespository.findTopByKeyword(TEST_KEYWORD));
    }

    @Test
    public void saveSearchKeyword2() {
        searchKeywordRespository.save(SearchKeyword.of(TEST_KEYWORD2));
        Assert.assertNotNull(searchKeywordRespository.findTop10ByOrderByCountDescIdDesc());
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void saveSearchKeywordSameKeyword() {
        searchKeywordRespository.save(SearchKeyword.of(TEST_KEYWORD2));
    }

    @Test
    public void saveSearchKeywordHistory() {

        SearchHistory searchHistory = SearchHistory.of(TEST_KEYWORD);
        searchHistory.setCreatedAt(LocalDateTime.now());
        searchHistory.setCreatedBy(USER_ID);
        searchHistoryRespository.save(searchHistory);

        List<SearchHistory> searchHistories = searchHistoryRespository.findByCreatedByOrderByCreatedAtDesc(USER_ID);
        Assert.assertNotNull(searchHistories);
        Assert.assertEquals(searchHistories.size(), 1);
    }
}