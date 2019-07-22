package com.circlee.bookbook.controller.api;

import com.circlee.bookbook.model.request.BookSearchReq;
import com.circlee.bookbook.model.response.BookItemRes;
import com.circlee.bookbook.model.response.PageableRes;
import com.circlee.bookbook.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    @GetMapping
    public PageableRes<BookItemRes> bookSearch(@Valid BookSearchReq bookSearchReq){
        return bookService.findBooksByKeyword(bookSearchReq);
    }



}
