package org.springframework.beans.factory;


/**
 * @author derekyi
 * @date 2020/11/22
 */
public interface BeanFactory {

	void registerBean(String name, Object bean);

	Object getBean(String name);
}
