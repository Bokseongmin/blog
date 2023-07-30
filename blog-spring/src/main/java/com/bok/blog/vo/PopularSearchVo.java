package com.bok.blog.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PopularSearchVo {
    private String popular_term;
    private int popular_search_cnt;
}
