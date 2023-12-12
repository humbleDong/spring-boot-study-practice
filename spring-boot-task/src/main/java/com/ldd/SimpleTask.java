package com.ldd;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Author ldd
 * @Date 2023/12/12
 */
@Slf4j
@Component
public class SimpleTask {

    @Scheduled(cron = "*/3 * * * * *")
    @Async
    public void printTask(){
        log.info("这是一个简单的计划任务");
    }
}
