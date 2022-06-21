package org.springframework.beans.factory.support;

import org.springframework.beans.BeansException;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

public interface BeanDefinitionReader {
    BeanDefinitionRegistry getRegistry();

    ResourceLoader getResourceLoader();

    int loadBeanDefinitions(String location) throws BeansException;

    int loadBeanDefinitions(Resource resource) throws BeansException;

    int loadBeanDefinitions(String... locations) throws BeansException;
}
