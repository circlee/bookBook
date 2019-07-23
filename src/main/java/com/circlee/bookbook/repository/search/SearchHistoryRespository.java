package com.circlee.bookbook.repository.search;

import com.circlee.bookbook.domain.search.SearchHistory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SearchHistoryRespository extends CrudRepository<SearchHistory, Long> {

    List<SearchHistory> findByCreatedByOrderByCreatedAtDesc(Long memberId);

}