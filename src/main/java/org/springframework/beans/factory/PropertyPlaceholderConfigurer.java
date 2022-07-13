package org.springframework.beans.factory;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.Properties;

/**
 * @author ywb
 * @Date 2022/7/13 10:51
 */
public class PropertyPlaceholderConfigurer implements BeanFactoryPostProcessor {
    public static final String PLACEHOLDER_PREFIX = "${";

    public static final String PLACEHOLDER_SUFFIX = "}";

    private String location;

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        // 加载属性配置文件
        Properties properties = this.loadProperties();

        // 属性值替换占位符
        processProperties(beanFactory, properties);
    }

    public void setLocation(String location) {
        this.location = location;
    }

    private Properties loadProperties() {
        try {
            DefaultResourceLoader resourceLoader = new DefaultResourceLoader();
            Resource resource = resourceLoader.getResource(location);
            Properties properties = new Properties();
            properties.load(resource.getInputStream());
            return properties;
        }catch (IOException e) {
            throw new BeansException("Could not load properties", e);
        }
    }

    private void processProperties(ConfigurableListableBeanFactory beanFactory, Properties properties) {
        for (String beanName : beanFactory.getBeanDefinitionNames()) {
            BeanDefinition beanDefinition = beanFactory.getBeanDefinition(beanName);
            this.resolvePropertyValues(beanDefinition, properties);
        }
    }

    private void resolvePropertyValues(BeanDefinition beanDefinition, Properties properties) {
        PropertyValues propertyValues = beanDefinition.getPropertyValues();
        for (PropertyValue propertyValue : propertyValues.getPropertyValueList()) {
            Object value = propertyValue.getValue();
            if (value instanceof String) {
                String strVal = (String) value;
                StringBuffer sbf = new StringBuffer(strVal);
                int startIndex = strVal.indexOf(PLACEHOLDER_PREFIX);
                int endIndex = strVal.indexOf(PLACEHOLDER_SUFFIX);
                if (startIndex != -1 && endIndex != -1 && startIndex < endIndex) {
                    String propKey = strVal.substring(startIndex + 2, endIndex);
                    String propVal = properties.getProperty(propKey);
                    sbf.replace(startIndex, endIndex + 1, propVal);
                    propertyValues.addPropertyValue(new PropertyValue(propertyValue.getName(), sbf.toString()));
                }
            }
        }
    }
}
