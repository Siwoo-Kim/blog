package com.siwoo.blog.service;

import com.siwoo.blog.domain.member.Member;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Pageable;
import java.util.List;

@Transactional
public interface MemberService {


    void join(Member member);

    @Transactional(readOnly = true)
    Page<Member> getMembers(Pageable pageable);

    @Transactional(readOnly = true)
    Member getMember(Long id);


}
