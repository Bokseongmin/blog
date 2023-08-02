package com.bok.blog.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long user_num;
    private String user_email;
    private String user_pw;
    private String user_pw_check;
    private String user_nick;
    private String user_thumb;
    private LocalDateTime user_regdate;
    private LocalDateTime user_moddate;
}
