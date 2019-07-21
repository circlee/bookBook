package com.circlee.bookbook.repository.member;

import com.circlee.bookbook.domain.member.Member;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends CrudRepository<Member, Long> {
}