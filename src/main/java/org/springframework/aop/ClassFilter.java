package org.springframework.aop;

/**
 * @author ywb
 * @Date 2022/6/29 17:45
 */
@FunctionalInterface
public interface ClassFilter {

    boolean matches(Class<?> clazz);
}
