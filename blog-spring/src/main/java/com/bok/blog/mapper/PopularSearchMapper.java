package com.bok.blog.mapper;

import com.bok.blog.vo.PopularSearchVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PopularSearchMapper {
    List<PopularSearchVo> list();
}
