package com.circlee.bookbook.domain.search;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Data
@Entity
@EqualsAndHashCode(of = "keyword")
@ToString
@EntityListeners({AuditingEntityListener.class})
public class SearchKeyword {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true, length=100)
    private String keyword;

    @Column(nullable = false)
    private Long count;


    public SearchKeyword(){}

    private SearchKeyword(String keyword) {
        this.keyword = keyword;
        this.count = 0L;
    }

    public static SearchKeyword of(String keyword) {
        return new SearchKeyword(keyword);
    }

}
