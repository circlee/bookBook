package com.circlee.bookbook.service;

import com.circlee.bookbook.model.request.BookSearchReq;
import com.circlee.bookbook.model.response.BookItemRes;
import com.circlee.bookbook.model.response.PageableRes;

public interface BookService {
    PageableRes<BookItemRes> findBooksByKeyword(BookSearchReq bookSearchReq);
}
