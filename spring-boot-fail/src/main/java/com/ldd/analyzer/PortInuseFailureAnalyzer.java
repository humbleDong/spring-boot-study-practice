package com.ldd.analyzer;

import org.springframework.boot.diagnostics.AbstractFailureAnalyzer;
import org.springframework.boot.diagnostics.FailureAnalysis;
import org.springframework.boot.web.server.PortInUseException;

/**
 * @Author  ldd
 * @Date  2023/12/6
*/
public class PortInuseFailureAnalyzer extends AbstractFailureAnalyzer<PortInUseException> {
    @Override
    protected FailureAnalysis analyze(Throwable rootFailure, PortInUseException cause) {
        return new FailureAnalysis(
                "你启动的端口" + cause.getPort() + " 被占用了.",
                "请你检查你的端口" + cause.getPort() + " 被哪一个程序占用了,或者强制杀掉进程",
                cause);
    }
}
