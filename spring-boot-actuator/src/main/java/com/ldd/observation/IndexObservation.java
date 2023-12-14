package com.ldd.observation;

import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationRegistry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Author ldd
 * @Date 2023/12/14
 */
@Slf4j
@RequiredArgsConstructor
@Component
public class IndexObservation {
    private final ObservationRegistry observationRegistry;

    public void observe(){
        Observation.createNotStarted("indexObservation",this.observationRegistry)
                .lowCardinalityKeyValue("area","com")
                .highCardinalityKeyValue("userId","10099")
                .observe(() ->{
                    //执行观测时的业务逻辑
                    log.info("开始执行业务逻辑");
                });
    }
}
