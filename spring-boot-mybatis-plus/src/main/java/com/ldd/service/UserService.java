package com.ldd.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ldd.pojo.User;

/**
 * @Author ldd
 * @Date 2023/12/11
 */
public interface UserService extends IService<User> {
    User getByUsername(String username, int type);
}
