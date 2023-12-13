package com.ldd.service.impl;

import com.ldd.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @Author ldd
 * @Date 2023/12/13
 */
@Service
public class UserServiceImpl implements UserService {

    @Override
    public int countAllUsers() {
        return 10;
    }

}
