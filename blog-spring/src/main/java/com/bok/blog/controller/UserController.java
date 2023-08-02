package com.bok.blog.controller;

import com.bok.blog.dto.ModifyUserDto;
import com.bok.blog.service.UserService;
import com.bok.blog.support.res.ResUtil;
import com.bok.blog.support.res.result.ResResult;
import com.bok.blog.support.res.result.ResStatus;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Resource
    private UserService userService;

    @PatchMapping("/")
    public ResponseEntity<ResResult> modifyUser(@RequestBody ModifyUserDto modifyUserDto, @AuthenticationPrincipal String user_email) {
        ResResult result;
        int affectRow = userService.modifyUser(modifyUserDto, user_email);
        if(affectRow > 0) {
            result = ResUtil.makeResult(ResStatus.OK, null);
        } else {
            result = ResUtil.makeResult("4444", "회원 정보 변경 중 오류가 발생했습니다.", null);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
