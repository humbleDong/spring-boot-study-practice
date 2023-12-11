package com.ldd.dao.impl;

import com.ldd.dao.UserDao;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author ldd
 * @Date 2023/12/11
 */

@RequiredArgsConstructor
@Service
public class UserDaoImpl implements UserDao {

    public final JdbcTemplate jdbcTemplate;

    @Transactional
    @Override
    public void update() {
        jdbcTemplate.execute("update t_user set username = 'xiaodong' where id = 1");
        jdbcTemplate.execute("update t_user set username = 'xiaojia' where id = 2");
        //throw new RuntimeException("test exception");
    }

}
