package com.bok.blog.mapper;

import com.bok.blog.vo.BoardVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

    List<BoardVo> top5();

    List<BoardVo> list();
}
