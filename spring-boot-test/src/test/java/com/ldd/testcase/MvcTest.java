package com.ldd.testcase;

import com.ldd.utils.Result;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @Author ldd
 * @Date 2023/12/13
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MvcTest {

    @Test
    public void getUserTest(@Autowired TestRestTemplate testRestTemplate){
        Map<String,String> multiValueMap= new HashMap<>();
        multiValueMap.put("username","七岁就很浪");
        Result result=testRestTemplate.getForObject("/user/get?username={username}",Result.class,multiValueMap);
        assertThat(result.getCode()).isEqualTo(0);
        assertThat(result.getMsg()).isEqualTo("ok");
    }
}
