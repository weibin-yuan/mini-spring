package org.springframework.beans.factory.config;

import org.springframework.beans.BeansException;

/**
 * @author ywb
 * @Date 2022/7/12 10:50
 */
public interface InstantiationAwareBeanPostProcessor extends BeanPostProcessor {

    /**
     * 在bean实例化之前执行
     *
     */
    Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException;
}
