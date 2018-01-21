package com.siwoo.blog.member;


import com.siwoo.blog.domain.member.Member;
import com.siwoo.blog.domain.member.MemberDomainException;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class MemberTest {

    //To verify initiate Member Domain
    @Test
    public void initiate(){

        Member member = Member.builder()
                .name("member1")
                .email("member1@email.com")
                .age(25)
                .password("member@@")
                //CHECK TO SEE DEFAULT IS BRONZE
                // .level(Member.Level.BRONZE)
                // .point(0)
                .build();

        assertThat("Default level must be BRONZE"
                ,member.getLevel(),is(Member.Level.BRONZE));
        assertThat("Default point must be 0"
                ,member.getPoint(),is(0));

    }

    @Test(expected = MemberDomainException.class)
    public void removePoint(){

        Member member = Member.builder()
                .name("member1")
                .email("member1@email.com")
                .age(25)
                .password("member@@")
                //CHECK TO SEE DEFAULT IS BRONZE
                // .level(Member.Level.BRONZE)
                // .point(0)
                .build();

        member.removePoint(10);
        fail();

    }


}
