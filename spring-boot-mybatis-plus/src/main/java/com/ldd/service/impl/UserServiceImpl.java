package com.ldd.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ldd.mapper.UserMapper;
import com.ldd.pojo.User;
import com.ldd.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Author ldd
 * @Date 2023/12/11
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    private final UserMapper userMapper;

    @Override
    public User getByUsername(String username, int type) {
        if (type == 0) {
            // xml
            log.info("query from xml");
            return userMapper.selectByUsername(username);
        } else {
            // QueryWrapper
            log.info("query from wrapper");
            LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper();
            queryWrapper.eq(User::getUsername, username);
            queryWrapper.eq(User::getStatus, 1);
            return userMapper.selectOne(queryWrapper);
        }

    }
}
