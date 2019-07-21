package com.circlee.bookbook.model.kakao.common;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class KakaoApiResponse<T> implements Serializable {

    protected Meta meta;
    protected List<T> documents;
}
