package com.ldd.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Author ldd
 * @Date 2023/12/13
 */
@Data
@AllArgsConstructor
public class User {

    private long id;

    private String name;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime birthday;

}
