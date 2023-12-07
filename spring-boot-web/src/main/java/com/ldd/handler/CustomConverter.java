package com.ldd.handler;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.convert.converter.Converter;

/**
 * @Author ldd
 * @Date 2023/12/7
 * 去掉请求参数中的首位空格
 */

@Slf4j
public class CustomConverter implements Converter<String, String> {

    @Override
    public String convert(String source) {
        if (StringUtils.isNoneEmpty(source)) {
            source = source.trim();
        }
        return source;
    }
}
