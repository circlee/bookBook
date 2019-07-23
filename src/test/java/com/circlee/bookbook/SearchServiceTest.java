package com.circlee.bookbook;


import com.circlee.bookbook.config.SpringSecurityWebAuxTestConfig;
import com.circlee.bookbook.service.SearchService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {SpringSecurityWebAuxTestConfig.class})
@ActiveProfiles("test")
@Slf4j
public class SearchServiceTest {

    @Autowired
    SearchService searchService;


    public static final String TEST_KEYWORD = "테스트";
    public static final Long TEST_USER_ID = 1L;

    @Test
    @WithUserDetails("test@test.com")
    public void saveSearchKeyword() {
        searchService.saveSearchHistory(TEST_KEYWORD);
    }


}