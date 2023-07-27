package com.bok.blog.service;

import com.bok.blog.dto.SignResDto;
import com.bok.blog.dto.UserDto;
import com.bok.blog.mapper.UserMapper;
import com.bok.blog.support.security.TokenProvider;
import com.bok.blog.vo.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service
public class AuthService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private TokenProvider tokenProvider;

    public int signUp(UserDto userDto) {
        String user_email = userDto.getUser_email();
        String user_pw = userDto.getUser_pw();
        String user_pw_check = userDto.getUser_pw_check();
        
        // user_email 중복체크
        try {
            if (userMapper.existUser_email(user_email) > 0) {
                log.warn("Exist Email");
                return 0;
            }
        } catch (Exception e) {
            log.error("DB error(existUser_email)");
            log.error("{}", e.getMessage());
            return 0;
        }
        
        // user_pw, user_pw_check 일치 확인

        if (!user_pw.equals(user_pw_check)) {
            log.error("Password does not matched");
            return 0;
        }

        // UserVo 생성
        UserVo userVo = new UserVo(userDto);

        // 회원 등록
        try {
            if (userMapper.signUp(userVo) > 0) {
                return 1;
            }
        } catch (Exception e) {
            log.error("DB error(signUp)");
            log.error("{}", e.getMessage());
            return 0;
        }
        return 1;
    }

    public SignResDto signIn(UserDto userDto) {
        String user_email = userDto.getUser_email();
        String user_pw = userDto.getUser_pw();
        UserVo userVo = new UserVo(userDto);

        int affectRow = 0;
        try {
            affectRow = userMapper.validation(userVo);
            if (affectRow == 0) {
                log.warn("Sign does not match");
                return null;
            }
        } catch (Exception e) {
            log.error("DB error(Sign Validation)");
            log.error("{}", e.getMessage());
            return null;
        }

        try {
            userVo = userMapper.signIn(user_email);
        } catch (Exception e) {
            log.error("DB error(signIn)");
            log.error("{}", e.getMessage());
            return null;
        }
        userVo.setUser_pw("");
        String token = tokenProvider.create(user_email);
        int exprTime = 3600000;

        return new SignResDto(token, exprTime, userVo);
    }
}
