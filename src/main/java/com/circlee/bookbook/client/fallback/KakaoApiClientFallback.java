package com.circlee.bookbook.client.fallback;

import com.circlee.bookbook.client.KakaoApiClient;
import com.circlee.bookbook.client.NaverApiClient;
import com.circlee.bookbook.exception.BookBookException;
import com.circlee.bookbook.model.kakao.KakaoBookApiResponse;
import com.circlee.bookbook.model.kakao.common.Book;
import com.circlee.bookbook.model.kakao.common.Meta;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class KakaoApiClientFallback implements KakaoApiClient {

    private final NaverApiClient naverApiClient;

    @Override
    public KakaoBookApiResponse searchBookByName(String query, int page, int size) {

        int start = ((page -1) * size) + 1;

        return Optional.ofNullable(naverApiClient.searchBookByName(query, start, size))
                .map( naverApiRes -> {


                    int total = naverApiRes.getTotal();
                    int limit = naverApiRes.getDisplay();

                    KakaoBookApiResponse response = new KakaoBookApiResponse();

                    Meta meta = new Meta();
                    meta.setIsEnd(page * size >= total);
                    meta.setPageableCount(total -1);
                    meta.setTotalCount(total);
                    response.setMeta(meta);

                    List<Book> kakaoBooks = naverApiRes.getItems().stream()
                            .map(item -> {
                                Book book = new Book();
                                book.setIsbn(item.getIsbn());
                                book.setContents(item.getDescription());
                                book.setTitle(item.getTitle());
                                book.setAuthors(Arrays.stream(item.getAuthor().split("\\|")).collect(Collectors.toList()));
                                book.setPublisher(item.getPublisher());
                                book.setDatetime(item.getPubdate());
                                book.setPrice(item.getPrice());
                                book.setSalePrice(item.getDiscount());
                                book.setThumbnail(item.getImage());
                                book.setUrl(item.getLink());
                                return book;
                            })
                            .collect(Collectors.toList());
                    response.setDocuments(kakaoBooks);

                    return response;
                })
                .orElseThrow(() -> new BookBookException(HttpStatus.INTERNAL_SERVER_ERROR, "검색 API에서 문제가 발생했습니다."));

    }


}
