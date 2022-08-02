package org.springframework.beans.factory;

import org.springframework.beans.BeansException;

/**
 * @author ywb
 * @Date 2022/8/1 15:38
 */
@FunctionalInterface
public interface ObjectFactory<T> {
    T getObject() throws BeansException;
}
