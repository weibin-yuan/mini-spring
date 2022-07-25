package org.springframework.core.convert.converter;

/**
 * @author ywb
 * @Date 2022/7/22 10:31
 */
@FunctionalInterface
public interface Converter<S, T> {
    T convert(S source);
}
