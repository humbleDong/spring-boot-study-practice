package com.ldd.po;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/**
 * @Author ldd
 * @Date 2023/12/7
 */
@Data
@AllArgsConstructor
public class OrderInfo {

    private String orderNo;

    private long amount;

    private Date time;

}
