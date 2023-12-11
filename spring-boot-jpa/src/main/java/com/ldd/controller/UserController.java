package com.ldd.controller;

import com.ldd.pojo.User;
import com.ldd.repo.UserRepository;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @Author ldd
 * @Date 2023/12/11
 */
@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserRepository userRepository;

    @GetMapping("/user/info/{id}")
    public User getUserInfo(@PathVariable("id")long id){
        return userRepository.findById(id).orElseGet(null);
    }
}
