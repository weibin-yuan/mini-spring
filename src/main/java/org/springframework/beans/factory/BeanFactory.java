package org.springframework.beans.factory;


import org.springframework.beans.BeansException;

/**
 * @author derekyi
 * @date 2020/11/22
 */
public interface BeanFactory {

	Object getBean(String name);

	<T> T getBean(String name, Class<T> requiredType) throws BeansException;

	<T> T getBean(Class<T> requiredType) throws BeansException;
}
