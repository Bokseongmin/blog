package com.bok.blog.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BoardDto {
    private Long board_num;
    private String board_title;
    private String board_content;
    private String board_img;
    private String board_video;
    private String board_file;

    private Long board_writer_num;
    private String board_writer_thumb;
    private String board_writer_nick;
    private String board_write_date;
    private int board_click_cnt;
    private int board_like_cnt;
    private int board_reply_cnt;
}
