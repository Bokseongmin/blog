package com.bok.blog.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class BoardVo {
    private Long board_num;
    private String board_title;
    private String board_content;
    private String board_img;
    private String board_video;
    private String board_file;

    private Long board_writer_num;
    private String board_writer_thumb;
    private String board_writer_nick;
    private LocalDateTime board_regdate;
    private LocalDateTime board_moddate;
    private int board_click_cnt;
    private int board_like_cnt;
    private int board_reply_cnt;
}
