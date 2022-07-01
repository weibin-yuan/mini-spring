package org.springframework.aop.framework;

/**
 * @author ywb
 * @Date 2022/7/1 10:24
 */
public interface AopProxy {
    Object getProxy();

    Object getProxy(ClassLoader classLoader);
}
