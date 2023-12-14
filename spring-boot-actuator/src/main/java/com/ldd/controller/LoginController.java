package com.ldd.controller;

import com.ldd.observation.IndexObservation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author ldd
 * @Date 2023/12/14
 */
@Slf4j
@RequiredArgsConstructor
@Controller
public class LoginController {

    private final IndexObservation indexObservation;

    @GetMapping("/")
    @ResponseBody
    public String index(){
        log.info("this is index page");
        indexObservation.observe();
        return "index page";
    }
}
