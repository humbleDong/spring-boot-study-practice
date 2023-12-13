package com.ldd.controller;

import com.ldd.utils.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author ldd
 * @Date 2023/12/13
 */
@RestController
public class UserController {

    @GetMapping(value = "/user/get")
    public Result getUserInfo(@RequestParam("username") String username) {
        Result result = new Result();
        result.setData(username);
        result.setMsg("ok");
        return result;
    }
}
