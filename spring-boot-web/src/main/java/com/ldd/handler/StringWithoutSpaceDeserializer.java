package com.ldd.handler;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;

/**
 * @Author ldd
 * @Date 2023/12/7
 * 反序列化过程中遇到不明确的参数时不用失败，并且配置了一个字符串的反序列化器，用来过滤HTTP请求字符串参数首尾的空格
 */

public class StringWithoutSpaceDeserializer extends StdDeserializer<String> {

    private static final long serialVersionUID = -6972065572263950443L;

    public StringWithoutSpaceDeserializer(Class<String> vc) {
        super(vc);
    }

    @Override
    public String deserialize(JsonParser p, DeserializationContext deserializationContext) throws IOException {
        return StringUtils.trimToEmpty(p.getText());
    }

}
