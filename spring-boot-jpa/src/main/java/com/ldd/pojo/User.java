package com.ldd.pojo;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author ldd
 * @Date 2023/12/11
 */
@Data
@Entity(name = "t_user")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String phone;

    @Column(name = "create_time", nullable = false)
    private Date createTime;

    @Column(nullable = false)
    private Integer status;

}