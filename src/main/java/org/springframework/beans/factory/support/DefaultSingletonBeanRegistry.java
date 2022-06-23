package org.springframework.beans.factory.support;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {
    private final Map<String, Object> singletonObjects = new ConcurrentHashMap<>(256);

    private final Map<String, Object> disposableBeans = new HashMap<>();

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

    public void registerDisposableBean(String beanName, Object disposableBean) {
        synchronized (this.disposableBeans) {
            this.disposableBeans.put(beanName, disposableBean);
        }
    }

    public void destroySingletons() {
        String[] disposeBeanNames;
        synchronized (this.disposableBeans) {
            disposeBeanNames = this.disposableBeans.keySet().toArray(new String[0]);
        }
        for (String beanName : disposeBeanNames) {
            DisposableBean disposableBean = (DisposableBean) this.disposableBeans.remove(beanName);
            try {
                disposableBean.destroy();
            }catch (Exception e) {
                throw new BeansException("Destroy method on bean with name '" + beanName + "' threw an exception", e);
            }
        }
    }
}
