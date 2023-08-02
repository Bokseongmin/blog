package com.bok.blog.dto;

import com.bok.blog.vo.UserVo;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SignResDto {
    private String token;
    private int exprTime;
    private UserVo userVo;
}
