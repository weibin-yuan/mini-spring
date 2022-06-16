package org.springframework.beans.factory.config;

import org.springframework.beans.PropertyValues;

/**
 * @author ywb
 */
public class BeanDefinition {
    private Object beanClass;

    private PropertyValues propertyValues;

    public BeanDefinition(Object beanClass) {
        this(beanClass, null);
    }

    public BeanDefinition(Object beanClass, PropertyValues propertyValues) {
        this.beanClass = beanClass;
        this.propertyValues = propertyValues != null ? propertyValues : new PropertyValues();
    }

    public void setBeanClass(Object beanClass) {
        this.beanClass = beanClass;
    }

    public Object getBeanClass() {
        return beanClass;
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }
}
