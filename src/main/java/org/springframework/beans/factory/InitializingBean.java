package org.springframework.beans.factory;

/**
 * @Date 2022/6/23 15:44
 * @Created ywb
 */
public interface InitializingBean {
    void afterPropertiesSet() throws Exception;
}
