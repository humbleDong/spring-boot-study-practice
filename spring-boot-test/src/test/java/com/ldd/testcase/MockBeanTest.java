package com.ldd.testcase;

import com.ldd.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @Author ldd
 * @Date 2023/12/13
 */
@SpringBootTest
public class MockBeanTest {

//    @Autowired
//    private  UserService userService;

    @MockBean
    private UserService userService;

    @Test
    public void countAllUser(){
        BDDMockito.given(this.userService.countAllUsers()).willReturn(88);
        assertThat(this.userService.countAllUsers()).isEqualTo(88);
    }
}
