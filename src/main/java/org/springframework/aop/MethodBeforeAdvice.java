package org.springframework.aop;

import java.lang.reflect.Method;

/**
 * @author ywb
 * @Date 2022/7/7 16:39
 */
public interface MethodBeforeAdvice extends BeforeAdvice {
    void before(Method method, Object[] args, Object target) throws Throwable;
}
