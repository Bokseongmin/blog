package com.bok.blog.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ReplyDto {
    private Long reply_num;
    private Long board_num;
    private Long user_num;
    private String reply_user_thumb;
    private String reply_user_nick;
    private String reply_write_date;
    private String reply_content;
}
