package com.bok.blog.service;

import com.bok.blog.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AuthService {

    @Resource
    private UserMapper userMapper;
}
