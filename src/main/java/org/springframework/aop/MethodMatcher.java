package org.springframework.aop;

import java.lang.reflect.Method;

/**
 * @author ywb
 * @Date 2022/6/29 17:56
 */
public interface MethodMatcher {
    boolean matches(Method method, Class<?> targetClass);
}
