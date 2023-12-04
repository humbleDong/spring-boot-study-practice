package com.ldd.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @Author ldd
 * @Date 2023/12/4
 */
@Component
@PropertySource(value = "classpath:db.properties")
public class DbProperties {

    @Value("${username}")
    private String username;
    @Value("${password}")
    private String password;

    public DbProperties() {
    }

    public DbProperties(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "DbProperties{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
