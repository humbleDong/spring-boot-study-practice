package com.ldd.endpoint;

import com.ldd.pojo.User;
import jakarta.annotation.Nullable;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.boot.actuate.endpoint.web.annotation.WebEndpoint;
import org.springframework.stereotype.Component;

/**
 * @Author ldd
 * @Date 2023/12/14
 */
@Component
@WebEndpoint(id="test")
public class TestEndpoint {
    @ReadOperation
    public User getUser(@Selector Integer id){
        return new User(id,"xiaodong",18);
    }

    @WriteOperation
    public User updateUser(int id, @Nullable String name,@Nullable Integer age){
        User user = getUser(id);
        user.setName(name);
        user.setAge(age);
        return user;
    }
}
