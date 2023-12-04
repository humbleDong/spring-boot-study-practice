# SpringBoot3.x学习

## 1.配置管理



### 1.1	自定义配置

#### @Configuration

```java
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Configuration
@Indexed
public @interface SpringBootConfiguration {
    @AliasFor(
        annotation = Configuration.class
    )
    boolean proxyBeanMethods() default true;
}
```

使用`@Configuration`可以自定义配置类





#### @Import

```java
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Import {
    //可以导入@Configuration，ImportSelector，ImportBeanDefinitionRegistrar或者任何一个Component组件
    Class<?>[] value();
}
```

用来处理配置类在其他子包或者在依赖jar包中，进行配置导入



#### @ImportResource

如果需要导入XML配置可以使用`@ImportResource`

```java
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
public @interface ImportResource {
    @AliasFor("locations")
    String[] value() default {};

    @AliasFor("value")
    String[] locations() default {};

    Class<? extends BeanDefinitionReader> reader() default BeanDefinitionReader.class;
}
```

使用方式就是直接指定要导入的XML配置文件路径即可





### 1.2	配置文件



#### application

SpringBoot应用的配置参数主要在application中

`StandardConfigDataLocationResolver`源码中定义

```java
static final String CONFIG_NAME_PROPERTY = "spring.config.name";
static final String[] DEFAULT_CONFIG_NAMES = new String[]{"application"};
```

**注：它可以有不同形式的配置方式，该配置文件不是必需的，可以有多个，也可以一个都没有**





#### bootstrap

属于SpringCloud环境，需要引入SpringCloud依赖。

bootstrap配置文件会优先于application配置文件被加载



#### 配置文件类型

.properties：key=value格式

.yml：key：value树状格式(yaml)

注：.yml配置文件不支持通过`@PropertySource`注解来导入配置









### 1.3  配置绑定

#### 1.3.1	Spring中的配置绑定

`@PropertySource`注解绑定配置

准备一个db.properties

```java
username=root
password=123456
```



```java
@Component
@PropertySource(value = "classpath:db.properties")
public class DbProperties {

    @Value("${username}")
    private String username;
    @Value("${password}")
    private String password;

    //有/无参构造，get/set,toString
}
```



测试：

```java
@SpringBootTest
public class Test1 {

    @Autowired
    private DbProperties dbProperties;

    @Test
    public  void test(){
        System.out.println(dbProperties);
    }
}
```

结果：

```txt
DbProperties{username='Administrator', password='123456'}
```



**注：因为@PropertySource注解并不支持主流的.yaml配置文件绑定，本身也要结合@Value注解使用，不推荐这种方式**

**但是可以用`@ConfigurationProperties`来实现，具体可以参照[.yaml注入配置](https://gh.qisui.xyz/undefined/e20c50ed.html#4-4注入配置文件)，它同时支持这两种文件格式。**





#### 1.3.2	参数绑定

通过javabean提供的setter方法进行配置参数与Java Bean字段的绑定，首先在application.yaml配置文件中加入person.*配置参数

```yaml
person:
  name: ldd
  age: 18
  happy: true
  birth: 2023/4/13
  maps: {k1: v1, k2: v2, k3: v3}
  lists:
    - sing
    - play
    - music
  db-properties:
    username: root
    password: 123456
```



在person实体类中进行参数绑定

```java
@Component
@ConfigurationProperties(prefix = "person")
public class Person {
    private String name;
    private Integer age;
    private Boolean happy;
    private Date birth;
    private Map<String,Object> maps;
    private List<Object> lists;
    private DbProperties dbProperties;
    
    //有/无参构造，get/set,toString
}
```



测试:

```JAVA
@Autowired
private Person person;

@Test
public  void testPerson(){
    System.out.println(person);
```

结果：

```txt
Person{
name='ldd', 
age=18, 
happy=true,
birth=Thu Apr 13 00:00:00 CST 2023,
maps={k1=v1, k2=v2, k3=v3}, 
lists=[sing, play, music], 
dbProperties=DbProperties{username='root1', password='123456'}}
```



通过`@ConfigurationProperties(prefix = "xxx")`注解绑定配置参数需要用到类的setter方法，该注解可以将配置参数映射到Java Bean上，该注解中的prefix或者value参数用于指定要映射的参数前缀，前缀格式为英文小写，多个前缀以"-"分割如上面db-properties



总结(@ConfigurationProperties)：

- 支持按配置参数前缀绑定参数，前缀一样的参数的配置参数将被绑定到同一个类上
- 支持配置参数使用默认值，如果happy=true,不设置，那么就会输出默认值false
- 支持松绑定，也就是连接符位置可以是“-”，也可是“_”
- 支持Java集合绑定，例如Map，List
- 支持嵌套类，例如dbProperties嵌套了一个类
- 支持主要的配置途径，比如：.yaml文件、.properties文件....
- 可以搭配`@EnableConfigurationProperties`来使用







#### 1.3.3	构造器绑定

