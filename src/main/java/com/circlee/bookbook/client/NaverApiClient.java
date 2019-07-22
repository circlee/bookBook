package com.circlee.bookbook.client;

import com.circlee.bookbook.model.naver.NaverBookApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="external-naver", url = "${external.naver.url}", primary = false, qualifier = "external-naver")
public interface NaverApiClient {

    @GetMapping(value = "v1/search/book.json"
            , headers = {"X-Naver-Client-Id=${external.naver.client-id}", "X-Naver-Client-Secret=${external.naver.client-secret}"})
    NaverBookApiResponse searchBookByName(@RequestParam("query") String query
            , @RequestParam("start") int start
            , @RequestParam("display") int display);

}
