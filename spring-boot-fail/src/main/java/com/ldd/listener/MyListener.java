package com.ldd.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.availability.AvailabilityChangeEvent;
import org.springframework.boot.availability.ReadinessState;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @Author ldd
 * @Date 2023/12/6
 */

@Slf4j
@Component
public class MyListener implements ApplicationListener<AvailabilityChangeEvent> {
    @Override
    public void onApplicationEvent(AvailabilityChangeEvent event) {
        log.info("监听到事件：",event);
        if (ReadinessState.ACCEPTING_TRAFFIC==event.getState()){
            log.info("应用启动完成，可以接受请求了.......");
        }
    }
}
