package org.springframework.beans.factory.support;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.SingletonBeanRegistry;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {
    private final Map<String, Object> singletonObjects = new ConcurrentHashMap<>(256);

    protected void addSingleton(String beanName, Object singletonBean) {
        Object oldObject = this.singletonObjects.get(beanName);
        if (oldObject != null) {
            throw new BeansException(beanName + ": There is already");
        }
        this.singletonObjects.put(beanName, singletonBean);
    }

    @Override
    public Object getSingleton(String beanName) {
        return this.singletonObjects.get(beanName);
    }
}
