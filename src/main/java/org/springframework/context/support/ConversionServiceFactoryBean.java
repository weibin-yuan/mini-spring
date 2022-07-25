package org.springframework.context.support;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.ConversionServiceFactory;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.core.convert.support.GenericConversionService;

import java.util.Set;

/**
 * @author ywb
 * @Date 2022/7/22 13:59
 */
public class ConversionServiceFactoryBean implements FactoryBean<ConversionService>, InitializingBean {

    private Set<?> converters;

    private GenericConversionService conversionService;

    @Override
    public void afterPropertiesSet() throws Exception {
        this.conversionService = this.createConversionService();
        ConversionServiceFactory.registerConverters(this.converters, this.conversionService);
    }

    protected GenericConversionService createConversionService() {
        return new DefaultConversionService();
    }

    @Override
    public ConversionService getObject() throws Exception {
        return this.conversionService;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    public void setConverters(Set<?> converters) {
        this.converters = converters;
    }
}
