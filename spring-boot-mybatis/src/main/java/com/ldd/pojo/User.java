package com.ldd.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author ldd
 * @Date 2023/12/11
 */
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String username;

    private String phone;

    private Date createTime;

    private Integer status;

}