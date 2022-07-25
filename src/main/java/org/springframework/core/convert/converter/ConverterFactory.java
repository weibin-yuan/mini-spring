package org.springframework.core.convert.converter;

/**
 * @author ywb
 * @Date 2022/7/22 10:36
 */
public interface ConverterFactory<S, R> {
    <T extends R> Converter<S, T> getConverter(Class<T> targetType);
}
