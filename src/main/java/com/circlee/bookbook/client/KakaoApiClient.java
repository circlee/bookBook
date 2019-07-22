package com.circlee.bookbook.client;

import com.circlee.bookbook.client.fallback.KakaoApiClientFallback;
import com.circlee.bookbook.model.kakao.KakaoBookApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(name="external-kakao", url = "${external.kakao.url}", fallback = KakaoApiClientFallback.class)
public interface KakaoApiClient {

    @GetMapping(value = "/v3/search/book?target=title", headers = {"Authorization=KakaoAK ${external.kakao.app-key}"})
    KakaoBookApiResponse searchBookByName(@RequestParam("query") String query
            , @RequestParam("page") int page
            , @RequestParam("size") int size);

}
