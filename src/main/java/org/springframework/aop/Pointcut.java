package org.springframework.aop;

/**
 * @author ywb
 * @Date 2022/6/29 17:54
 */
public interface Pointcut {

    ClassFilter getClassFilter();

    MethodMatcher getMethodMatcher();
}
