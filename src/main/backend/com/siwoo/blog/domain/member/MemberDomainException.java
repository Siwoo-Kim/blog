package com.siwoo.blog.domain.member;

import com.siwoo.blog.domain.DomainException;

public class MemberDomainException extends DomainException {

    public MemberDomainException(String message, String code) {
        super(message, code);
    }

}
