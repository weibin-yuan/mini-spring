package org.springframework.aop;

import org.aopalliance.aop.Advice;

/**
 * @author ywb
 * @Date 2022/7/7 18:15
 */
public interface Advisor {
    Advice EMPTY_ADVICE = new Advice() {
    };

    Advice getAdvice();
}
