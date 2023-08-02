package com.bok.blog.mapper;

import com.bok.blog.vo.UserVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int existUser_email(String user_email);

    int signUp(UserVo userVo);

    int validation(UserVo userVo);

    UserVo signIn(String user_email);

    UserVo info(String user_email);

    int modify(UserVo userVo);
}
