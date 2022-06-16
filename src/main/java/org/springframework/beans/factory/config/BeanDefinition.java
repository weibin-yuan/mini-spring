package org.springframework.beans.factory.config;

/**
 * @author ywb
 */
public class BeanDefinition {
    private Object beanClass;

    public BeanDefinition(Object beanClass) {
        this.beanClass = beanClass;
    }

    public void setBeanClass(Object beanClass) {
        this.beanClass = beanClass;
    }

    public Object getBeanClass() {
        return beanClass;
    }
}
