package com.circlee.bookbook.repository.search;

import com.circlee.bookbook.domain.search.SearchKeyword;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SearchKeywordRespository extends CrudRepository<SearchKeyword, Long> {

    SearchKeyword findTopByKeyword(String keyword);

    @Modifying
    @Query("update SearchKeyword sk set sk.count = sk.count +1 where sk = :searchKeyword ")
    int updateSearchKeywordCount(@Param("searchKeyword") SearchKeyword searchKeyword);

    List<SearchKeyword> findTop10ByOrderByCountDescIdDesc();
}