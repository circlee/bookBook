package com.circlee.bookbook.service.impl;

import com.circlee.bookbook.client.KakaoApiClient;
import com.circlee.bookbook.exception.BookBookException;
import com.circlee.bookbook.model.kakao.KakaoBookApiResponse;
import com.circlee.bookbook.model.kakao.common.Meta;
import com.circlee.bookbook.model.request.BookSearchReq;
import com.circlee.bookbook.model.response.BookItemRes;
import com.circlee.bookbook.model.response.PageableRes;
import com.circlee.bookbook.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final KakaoApiClient kakaoApiClient;

    @Override
    public PageableRes<BookItemRes> findBooksByKeyword(final BookSearchReq bookSearchReq) {
        KakaoBookApiResponse kakaoBookApiResponse = kakaoApiClient.searchBookByName(bookSearchReq.getKeyword(), bookSearchReq.getPageNo(), bookSearchReq.getLimit());

        return Optional.ofNullable(kakaoBookApiResponse)
                .map(kakaoApiRes -> {

                    PageableRes<BookItemRes> pageableRes = new PageableRes<>();

                    Meta meta = kakaoApiRes.getMeta();
                    pageableRes.setLimit(bookSearchReq.getLimit());
                    pageableRes.setTotalCount(meta.getTotalCount());

                    List<BookItemRes> bookItemResList = kakaoApiRes.getDocuments().stream()
                            .map(BookItemRes::ofKakaoBook)
                            .collect(Collectors.toList());

                    pageableRes.setItems(bookItemResList);


                    return pageableRes;
                })
                .orElseThrow(() -> new BookBookException(HttpStatus.INTERNAL_SERVER_ERROR, "검색 API에서 문제가 발생했습니다."));

    }

}
