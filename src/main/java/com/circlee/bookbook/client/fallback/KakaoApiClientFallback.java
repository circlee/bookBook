package com.circlee.bookbook.client.fallback;

import com.circlee.bookbook.client.KakaoApiClient;
import com.circlee.bookbook.client.NaverApiClient;
import com.circlee.bookbook.model.kakao.KakaoBookApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class KakaoApiClientFallback implements KakaoApiClient {

    private final NaverApiClient naverApiClient;

    @Override
    public KakaoBookApiResponse searchBookByName(String query) {

//        return naverApiClient.searchBookByName(query);
        return null;
    }
}
