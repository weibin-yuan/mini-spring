package org.springframework.core.convert.converter;

/**
 * @author ywb
 * @Date 2022/7/22 14:14
 */
public interface ConverterRegistry {

    void addConverter(Converter<?, ?> converter);

    void addConverterFactory(ConverterFactory<?, ?> converterFactory);

    void addConverter(GenericConverter converter);
}
