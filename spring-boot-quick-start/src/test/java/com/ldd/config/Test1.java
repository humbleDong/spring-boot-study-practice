package com.ldd.config;

import com.ldd.pojo.DbProperties;
import com.ldd.pojo.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author ldd
 * @Date 2023/12/4
 */
@SpringBootTest
public class Test1 {

    @Autowired
    private DbProperties dbProperties;

    @Autowired
    private Person person;

    @Test
    public  void test(){
        System.out.println(dbProperties);
    }


    @Test
    public  void testPerson(){
        System.out.println(person);
    }
}
