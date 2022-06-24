package org.springframework.context;

import org.springframework.beans.BeansException;

/**
 * @Date 2022/6/24 16:37
 * @Created ywb
 */
public interface ApplicationContextAware {
    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;
}
