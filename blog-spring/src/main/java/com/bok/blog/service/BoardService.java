package com.bok.blog.service;

import com.bok.blog.mapper.BoardMapper;
import com.bok.blog.mapper.PopularSearchMapper;
import com.bok.blog.vo.BoardVo;
import com.bok.blog.vo.PopularSearchVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class BoardService {
    @Resource
    private BoardMapper boardMapper;

    @Resource
    private PopularSearchMapper popularSearchMapper;

    public List<BoardVo> top5() {
        List<BoardVo> top5 = null;
        try {
            top5 = boardMapper.top5();
        } catch (Exception e) {
            log.error("DB Error(board.top5)");
            log.error("{}", e.getMessage());
        }
        return top5;
    }

    public List<BoardVo> list() {
        List<BoardVo> list = null;
        try {
            list = boardMapper.list();
        } catch (Exception e) {
            log.error("DB Error(board.list)");
            log.error("{}", e.getMessage());
        }
        return list;
    }

    public List<PopularSearchVo> popularSearchList() {
        List<PopularSearchVo> list = null;
        try {
            list = popularSearchMapper.list();
        } catch (Exception e) {
            log.error("DB Error(popularSearch.list)");
            log.error("{}", e.getMessage());
        }

        return list;
    }
}
