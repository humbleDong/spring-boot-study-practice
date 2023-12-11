package com.ldd.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ldd.pojo.User;
import org.apache.ibatis.annotations.Param;

/**
 * @Author ldd
 * @Date 2023/12/11
 */
public interface UserMapper extends BaseMapper<User> {
    User selectByUsername(@Param("username") String username);
}
