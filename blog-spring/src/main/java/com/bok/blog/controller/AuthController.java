package com.bok.blog.controller;

import com.bok.blog.service.UserService;
import com.bok.blog.support.res.result.ResResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Resource
    private UserService userService;

    @PostMapping("/signUp")
    public ResponseEntity<ResResult> signUp(@RequestBody Map<String, String> data) {
        System.out.println(data.toString());
        return null;
    }
}
