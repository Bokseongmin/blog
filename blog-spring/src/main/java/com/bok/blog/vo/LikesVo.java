package com.bok.blog.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LikesVo {
    private Long likes_num;
    private Long board_num;
    private Long user_num;
    private String likes_user_nick;
    private String like_user_thumb;
}
