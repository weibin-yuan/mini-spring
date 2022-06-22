package org.springframework.context;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public interface ConfigurableApplicationContext extends ApplicationContext {
    void refresh() throws BeansException;

    ConfigurableListableBeanFactory getBeanFactory();
}
