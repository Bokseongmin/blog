package com.bok.blog.dto;

import com.bok.blog.vo.UserVo;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SignResDto {
    private String token;
    private int exprTime;
    private UserVo userVo;

    public SignResDto(String token, int exprTime, UserVo userVo) {
        this.token = token;
        this.exprTime = exprTime;
        this.userVo = userVo;
    }
}
