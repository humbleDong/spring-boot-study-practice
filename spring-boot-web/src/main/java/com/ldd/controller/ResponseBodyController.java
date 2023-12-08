package com.ldd.controller;

import com.ldd.po.OrderInfo;
import com.ldd.po.User;
import com.ldd.po.UserXml;
import jakarta.validation.constraints.Size;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author ldd
 * @Date 2023/12/7
 * json和XML数据测试
 */
@Controller
@Slf4j
@Validated
public class ResponseBodyController {

    @CrossOrigin
    @ResponseBody
    @GetMapping(value = "/user/json/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public User getJsonUserInfo(@PathVariable("userId") @Size(min = 5, max = 8) String userId) {
        User user = new User("大大怪", 18);
        user.setId(Long.valueOf(userId));
        log.info("user info: {}", user);
        return user;
    }

    @ResponseBody
    @PostMapping
    public ResponseEntity saveUser(@RequestBody @Validated User user){
        user.setId(RandomUtils.nextLong());
        return new ResponseEntity(user, HttpStatus.OK);
    }

    @ResponseBody
    @GetMapping(value = "/user/xml/{userId}", produces = MediaType.APPLICATION_XML_VALUE)
    public UserXml getXmlUserInfo(@PathVariable("userId") String userId) {
        UserXml user = new UserXml();
        user.setName("小小怪");
        user.setId(userId);

        List<OrderInfo> orderList = new ArrayList<>();
        OrderInfo orderInfo1 = new OrderInfo("123456001", 999, new Date());
        OrderInfo orderInfo2 = new OrderInfo("123456002", 777, new Date());
        OrderInfo orderInfo3 = new OrderInfo("123456003", 666, new Date());
        orderList.add(orderInfo1);
        orderList.add(orderInfo2);
        orderList.add(orderInfo3);
        user.setOrderList(orderList);

        return user;
    }

    @GetMapping(value = "/index")
    public String index(){
        return "index";
    }
}
