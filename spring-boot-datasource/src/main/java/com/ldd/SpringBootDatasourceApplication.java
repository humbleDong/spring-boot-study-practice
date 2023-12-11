package com.ldd;

import com.ldd.dao.UserDao;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@SpringBootApplication
public class SpringBootDatasourceApplication {

    public final JdbcTemplate jdbcTemplate;

    public final UserDao userDao;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDatasourceApplication.class, args);
    }

    //测试数据库操作
//    @Bean
//    public CommandLineRunner commandLineRunner(){
//        return (args) ->{
//            String username=jdbcTemplate.queryForObject("select username from t_user where id=2",String.class);
//            log.info("query username is:{}",username);
//        };
//    }

    /**
     * 测试自定义jdbcTemplate
     */

    @Bean
    public CommandLineRunner commandLineRunner() {
        return (args) -> {
            String username = jdbcTemplate.queryForObject("select username from t_user where id = 2",
                    String.class);
            log.info("query username is : {}", username);

            List<Map<String, Object>> list = jdbcTemplate.queryForList("select id from t_user");
            log.info("total list: {}", list.size());

            userDao.update();
        };
    }


}
