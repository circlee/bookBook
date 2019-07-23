package com.circlee.bookbook.domain.search;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@EqualsAndHashCode(of = "id")
@ToString
@EntityListeners({AuditingEntityListener.class})
public class SearchHistory {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, length=100)
    private String keyword;

    @CreatedBy
    private Long createdBy;

    @CreatedDate
    private LocalDateTime createdAt;

    public SearchHistory(){}

    private SearchHistory(String keyword) {
        this.keyword = keyword;
    }

    public static SearchHistory of(String keyword) {
        return new SearchHistory(keyword);
    }

}
