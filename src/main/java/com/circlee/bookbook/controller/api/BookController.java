package com.circlee.bookbook.controller.api;

import com.circlee.bookbook.client.KakaoApiClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/books")
public class BookController {

    private final KakaoApiClient kakaoApiClient;

    @GetMapping
    public Object bookSearch(){
        return kakaoApiClient.searchBookByName("미움 받을 용기");
    }


    @GetMapping("/test")
    public Object test(){
        return kakaoApiClient.searchBookByName("미움 받을 용기");
    }


}
