package com.bok.blog.vo;

import com.bok.blog.dto.UserDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class UserVo {
    private Long user_num;
    private String user_email;
    private String user_pw;
    private String user_nick;
    private String user_thumb;
    private LocalDateTime user_regdate;
    private LocalDateTime user_moddate;

    public UserVo(UserDto userDto) {
        this.user_num = userDto.getUser_num();
        this.user_email = userDto.getUser_email();
        this.user_pw = userDto.getUser_pw();
        this.user_nick = userDto.getUser_nick();
        this.user_thumb = userDto.getUser_thumb();
    }
}
