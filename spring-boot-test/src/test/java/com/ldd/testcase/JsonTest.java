package com.ldd.testcase;

import com.ldd.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.json.JacksonTester;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @Author ldd
 * @Date 2023/12/13
 */
@org.springframework.boot.test.autoconfigure.json.JsonTest
public class JsonTest {
    @Autowired
    private JacksonTester<User> json;

    @Test
    void serialize() throws Exception {
        User user = new User(10001L, "xiaodong", LocalDateTime.of(2002, 8, 24, 21, 0, 0));
        System.out.println(this.json.write(user));
        assertThat(this.json.write(user)).isEqualToJson("/ldd.json");
        assertThat(this.json.write(user)).hasJsonPathStringValue("@.name");
        assertThat(this.json.write(user))
                .extractingJsonPathStringValue("@.name").isEqualTo("xiaodong");
    }

    @Test
    void deserialize() throws Exception {
        String content = "{\"id\":10002, \"name\":\"xiaojia\", \"birthday\": \"2003-05-30T02:32:00\"}";
        assertThat(this.json.parse(content))
                .isEqualTo(new User(10002L, "xiaojia",
                        LocalDateTime.of(2003, 5, 30, 2, 32, 0)));
        assertThat(this.json.parseObject(content).getName()).isEqualTo("xiaojia");
    }
}
