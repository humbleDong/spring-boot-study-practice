package com.ldd.analyzer;

import org.springframework.boot.diagnostics.AbstractFailureAnalyzer;
import org.springframework.boot.diagnostics.FailureAnalysis;

/**
 * @Author  ldd
 * @Date  2023/12/6
*/
public class MyStackFailureAnalyzer extends AbstractFailureAnalyzer<MyStackException> {

    @Override
    protected FailureAnalysis analyze(Throwable rootFailure, MyStackException cause) {
        return new FailureAnalysis("我的栈发生异常了……",
                "赶快去检查一下吧！",
                cause);
    }
}
