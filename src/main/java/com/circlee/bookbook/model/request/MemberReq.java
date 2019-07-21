package com.circlee.bookbook.model.request;

import com.circlee.bookbook.domain.member.Member;
import jdk.nashorn.internal.ir.annotations.Ignore;
import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.Pattern;
import java.io.Serializable;

@Data
public class MemberReq implements Serializable {
    public MemberReq(){

    }

    @NonNull
    @Pattern(regexp = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$"
            , flags = {Pattern.Flag.CASE_INSENSITIVE}
            , message = "email 형식으로 입력되어야 합니다.")
    private String email;

    @NonNull
    @Pattern(regexp = "((?=.*[a-z])(?=.*\\d)(?=.*[A-Z])(?=.*[@#$%!]).{8,40})"
            , message = "8자~40자, 숫자, 소문자, 대문자, 특수기호(@#$%!) 가 포함되어야 합니다.")
    private String password;

    @Ignore
    public Member toMember(){
        Member member = new Member();
        member.setUid(email);
        member.setUpw(password);
        return member;
    }
}
