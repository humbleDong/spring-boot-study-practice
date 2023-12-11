package com.ldd.mapper;

import com.ldd.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author ldd
 * @Date 2023/12/11
 */
@Mapper
public interface UserMapper {
    User findById(@Param("id") long id);
}
