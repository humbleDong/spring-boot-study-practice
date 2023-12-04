package com.ldd.pojo;

import jakarta.validation.constraints.Email;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Author ldd
 * @Date 2023/12/4
 */

/**
 * @ConfigurationProperties作用： 将配置文件中配置的每一个属性的值，映射到这个组件中；
 * 告诉SpringBoot将本类中的所有属性和配置文件中相关的配置进行绑定
 * 参数 prefix = “person” : 将配置文件中的person下面的所有属性一一对应
 */

@Component
@ConfigurationProperties(prefix = "person")
@Validated//加入JSR-303数据校验
public class Person {
//    //我们现在希望name是一个邮箱
//    @Email(message = "大哥，请你输入一个正确的邮箱！")//需要导入import org.springframework.validation.annotation.Validated;包
    private String name;
    private Integer age;
    private Boolean happy;
    private Date birth;
    private Map<String, Object> maps;
    private List<Object> lists;
    private DbProperties dbProperties;

    public Person() {
    }

    public Person(String name, Integer age, Boolean happy, Date birth, Map<String, Object> maps, List<Object> lists, DbProperties dbProperties) {
        this.name = name;
        this.age = age;
        this.happy = happy;
        this.birth = birth;
        this.maps = maps;
        this.lists = lists;
        this.dbProperties = dbProperties;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getHappy() {
        return happy;
    }

    public void setHappy(Boolean happy) {
        this.happy = happy;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Map<String, Object> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, Object> maps) {
        this.maps = maps;
    }

    public List<Object> getLists() {
        return lists;
    }

    public void setLists(List<Object> lists) {
        this.lists = lists;
    }

    public DbProperties getDbProperties() {
        return dbProperties;
    }

    public void setDbProperties(DbProperties dbProperties) {
        this.dbProperties = dbProperties;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", happy=" + happy +
                ", birth=" + birth +
                ", maps=" + maps +
                ", lists=" + lists +
                ", dbProperties=" + dbProperties +
                '}';
    }
}
