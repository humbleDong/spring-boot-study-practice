package com.ldd.po;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author ldd
 * @Date 2023/12/7
 */
@Data
@NoArgsConstructor
public class User {

    public User(String userName, Integer age) {
        this.userName = userName;
        this.age = age;
    }

    private Long id;

    @NotNull
    @JsonProperty(value = "username", required = true)
    @Size(min = 5, max = 10)
    private String userName;

    @NotNull
    private Integer age;

    @JsonIgnore
    private String address;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String memo;


}
