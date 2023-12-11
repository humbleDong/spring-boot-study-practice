package com.ldd.controller;

import com.ldd.pojo.User;
import com.ldd.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author ldd
 * @Date 2023/12/11
 */
@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;

    @GetMapping("/user/info/{id}")
    public User getUserInfoById(@PathVariable("id") long id){
        return userService.getById(id);
    }

    @GetMapping("/user/info/{username}/{type}")
    public User getUserInfoByUsername(@PathVariable("username") String username,@PathVariable("type")int type){
        return userService.getByUsername(username,type);
    }
}
