package com.bok.blog.controller;

import com.bok.blog.service.BoardService;
import com.bok.blog.support.res.ResUtil;
import com.bok.blog.support.res.result.ResResult;
import com.bok.blog.support.res.result.ResStatus;
import com.bok.blog.vo.BoardVo;
import com.bok.blog.vo.PopularSearchVo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/board")
public class BoardController {
    @Resource
    private BoardService boardService;
    @GetMapping("/top5")
    public ResponseEntity<ResResult> getTop5() {
        ResResult result;
        List<BoardVo> top5 = boardService.top5();
        if(top5 != null) {
            result = ResUtil.makeResult(ResStatus.OK, top5);
        } else {
            result = ResUtil.makeResult("4444", "데이터가 존재하지 않습니다.", null);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<ResResult> getList() {
        ResResult result;
        List<BoardVo> list = boardService.list();
        if(list != null) {
            result = ResUtil.makeResult(ResStatus.OK, list);
        } else {
            result = ResUtil.makeResult("4444", "데이터가 존재하지 않습니다.", null);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/popularSearchList")
    public ResponseEntity<ResResult> getPopularSearchList() {
        ResResult result;
        List<PopularSearchVo> list = boardService.popularSearchList();
        if(list != null) {
            result = ResUtil.makeResult(ResStatus.OK, list);
        } else {
            result = ResUtil.makeResult("4444", "데이터가 존재하지 않습니다.", null);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
