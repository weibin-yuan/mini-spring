package org.springframework.beans.factory;

/**
 * @Date 2022/6/27 16:48
 * @Created ywb
 */
public interface FactoryBean<T> {
    T getObject() throws Exception;

    boolean isSingleton();
}
