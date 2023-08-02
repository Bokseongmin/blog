package com.bok.blog.service;

import com.bok.blog.dto.ModifyUserDto;
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

    public int modifyUser(ModifyUserDto modifyUserDto, String user_email) {
        int affectRow = 0;
        UserVo userVo = null;
        String user_nick = modifyUserDto.getUser_nick();
        String user_thumb = modifyUserDto.getUser_thumb();
        try {
            userVo = userMapper.info(user_email);
            if (userVo == null) {
                log.warn("Does not exist user");
            } else {
                userVo.setUser_nick(user_nick);
                userVo.setUser_thumb(user_thumb);

                affectRow = userMapper.modify(userVo);
            }
        } catch (Exception e) {
            log.error("DB Error(board.searchList)");
            log.error("{}", e.getMessage());
        }
        return affectRow;
    }
}
