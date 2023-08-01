package com.bok.blog.service;

import com.bok.blog.mapper.UserMapper;
import com.bok.blog.vo.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    public UserVo patchUser(String user_email) {
        UserVo userVo = null;
        try {
            userVo = userMapper.info(user_email);
            if(userVo == null) {
                return null;
            }
        } catch (Exception e) {
            log.error("DB Error(board.searchList)");
            log.error("{}", e.getMessage());
        }
        return userVo;
    }
}
