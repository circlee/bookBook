package com.circlee.bookbook.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(name="external-naver", url = "${external.naver.url}", primary = false, qualifier = "external-naver")
public interface NaverApiClient {

    @GetMapping(value = "v1/search/book.json"
            , headers = {"X-Naver-Client-Id=${external.naver.client-id}", "X-Naver-Client-Secret=${external.naver.client-secret}"})
    Map<String, Object> searchBookByName(@RequestParam("query") String query);

}
