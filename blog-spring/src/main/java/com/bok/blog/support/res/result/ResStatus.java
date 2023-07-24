package com.bok.blog.support.res.result;

import lombok.Getter;

@Getter
public enum ResStatus {
    OK("200", "OK"),
    BAD_REQUEST("400", "Bad Request"),
    NOT_FOUND("404", "Not Found"),
    ERROR("500", "Internal Server Error");

    private final String code;
    private final String msg;

    ResStatus(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
