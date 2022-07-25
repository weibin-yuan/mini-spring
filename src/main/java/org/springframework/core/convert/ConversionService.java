package org.springframework.core.convert;

/**
 * @author ywb
 * @Date 2022/7/22 13:55
 */
public interface ConversionService {
    boolean canConvert(Class<?> sourceType, Class<?> targetType);

    <T> T convert(Object source, Class<T> targetType);
}
