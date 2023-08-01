package com.bok.blog.controller;

import com.bok.blog.dto.UserDto;
import com.bok.blog.support.res.result.ResResult;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @PatchMapping("/")
    public ResponseEntity<ResResult> modifyUser(@RequestBody UserDto userDto, @AuthenticationPrincipal String user_email) {
        return null;
    }
}
