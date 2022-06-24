package org.springframework.beans.factory;

import org.springframework.beans.BeansException;

/**
 * @Date 2022/6/24 16:39
 * @Created ywb
 */
public interface BeanFactoryAware {
    void setBeanFactory(BeanFactory beanFactory) throws BeansException;
}
