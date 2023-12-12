package com.ldd;

import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * @Author ldd
 * @Date 2023/12/12
 */
@Slf4j
public class SimpleTask extends QuartzJobBean {
    @Override
    protected void executeInternal(JobExecutionContext context){
        log.info("这是一个简单的Quartz计划任务");
    }
}
