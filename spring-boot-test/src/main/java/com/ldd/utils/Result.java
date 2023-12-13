package com.ldd.utils;

import lombok.Data;

/**
 * @Author ldd
 * @Date 2023/12/13
 */
@Data
public class Result {
    private int code = 0;

    private String msg;

    private Object data;
}
