package com.bok.blog.controller;

import com.bok.blog.dto.UserDto;
import com.bok.blog.service.AuthService;
import com.bok.blog.service.UserService;
import com.bok.blog.support.res.ResUtil;
import com.bok.blog.support.res.result.ResResult;
import com.bok.blog.support.res.result.ResStatus;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Resource
    private AuthService authService;

    @PostMapping("/signUp")
    public ResponseEntity<ResResult> signUp(@RequestBody UserDto userDto) {
        ResResult result;
        int affectRow = authService.signUp(userDto);
        if(affectRow > 0) {
            result = ResUtil.makeResult(ResStatus.OK, null);
        } else {
            result = ResUtil.makeResult("4444", "회원 등록 중 오류가 발생했습니다.", null);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/signIn")
    public ResponseEntity<ResResult> signIn(@RequestBody UserDto userDto) {
        ResResult result;
        int affectRow = authService.signIn(userDto);
        if(affectRow > 0) {
            result = ResUtil.makeResult(ResStatus.OK, null);
        } else {
            result = ResUtil.makeResult("4444", "로그인 중 오류가 발생했습니다.", null);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
