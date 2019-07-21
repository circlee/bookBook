package com.circlee.bookbook.controller.auth;

import com.circlee.bookbook.exception.BookBookBindingException;
import com.circlee.bookbook.exception.BookBookException;
import com.circlee.bookbook.model.request.MemberReq;
import com.circlee.bookbook.model.response.BaseRes;
import com.circlee.bookbook.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final MemberService memberService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/signup")
    public BaseRes test(@RequestBody @Valid MemberReq memberReq, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            throw new BookBookBindingException(bindingResult);
        }

        try {
            memberService.createMember(memberReq.toMember());
        } catch (DuplicateKeyException de) {
            throw new BookBookException(HttpStatus.BAD_REQUEST, "ID가 이미 존재합니다.");
        }

        return BaseRes.of("OK");
    }
}
