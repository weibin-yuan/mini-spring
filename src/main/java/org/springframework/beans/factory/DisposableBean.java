package org.springframework.beans.factory;

/**
 * @Date 2022/6/23 11:46
 * @Created ywb
 */
public interface DisposableBean {
    void destroy() throws Exception;
}
