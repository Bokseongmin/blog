package com.bok.blog.vo;

import com.bok.blog.dto.BoardDto;
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
    private LocalDateTime board_regdate;
    private LocalDateTime board_moddate;

    private Long board_writer_num;
    private String board_writer_thumb;
    private String board_writer_nick;

    private int board_click_cnt;
    private int board_like_cnt;
    private int board_reply_cnt;

    public BoardVo(BoardDto boardDto) {
        this.board_num = boardDto.getBoard_num();
        this.board_title = boardDto.getBoard_title();
        this.board_content = boardDto.getBoard_content();
        this.board_img = boardDto.getBoard_img();
        this.board_video = boardDto.getBoard_video();
        this.board_file = boardDto.getBoard_file();
        this.board_regdate = boardDto.getBoard_regdate();
        this.board_moddate = boardDto.getBoard_moddate();
        this.board_writer_num = boardDto.getBoard_writer_num();
        this.board_writer_thumb = boardDto.getBoard_writer_thumb();
        this.board_writer_nick = boardDto.getBoard_writer_nick();
        this.board_click_cnt = boardDto.getBoard_click_cnt();
        this.board_like_cnt = boardDto.getBoard_like_cnt();
        this.board_reply_cnt = boardDto.getBoard_reply_cnt();
    }
}
