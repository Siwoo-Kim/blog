package com.siwoo.blog.domain;

import lombok.Getter;

@Getter
public class DomainException extends  RuntimeException{

    private String code;

    public DomainException(String message, String code) {
        super(message);
        this.code = code;
    }

}
