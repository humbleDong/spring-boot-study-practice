package com.ldd.controller;

import com.ldd.mapper.UserMapper;
import com.ldd.pojo.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author ldd
 * @Date 2023/12/11
 */
@Slf4j
@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserMapper userMapper;

    @GetMapping("/user/info/{id}")
    public User getUserInfo(@PathVariable("id") long id) {
        User user = userMapper.findById(id);
        log.info("user: {}", user);
        return user;
    }

}
