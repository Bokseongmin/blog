package com.bok.blog.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserDto {
    private Long user_num;
    private String user_email;
    private String user_pw;
    private String user_pw_check;
    private String user_nick;
    private String user_thumb;
}
