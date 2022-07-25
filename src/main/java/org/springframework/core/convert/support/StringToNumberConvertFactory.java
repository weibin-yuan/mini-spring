package org.springframework.core.convert.support;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;

/**
 * @author ywb
 * @Date 2022/7/22 10:42
 */
public class StringToNumberConvertFactory implements ConverterFactory<String, Number> {
    @Override
    public <T extends Number> Converter<String, T> getConverter(Class<T> targetType) {
        return new StringToNumber<>(targetType);
    }

    private static final class StringToNumber<T extends Number> implements Converter<String, T> {
        private final Class<T> targetType;

        private StringToNumber(Class<T> targetType) {
            this.targetType = targetType;
        }

        @Override
        @SuppressWarnings("unchecked")
        public T convert(String source) {
            if (source.isEmpty()) {
                return null;
            }
            if (targetType.equals(Integer.class)) {
                return (T) Integer.valueOf(source);
            }else if (targetType.equals(Long.class)) {
                return (T) Long.valueOf(source);
            }
            // todo 其它数字类型
            else {
                throw new IllegalArgumentException("Cannot convert String [" + source + "] to target class [" + targetType.getName() + "]");
            }
        }
    }
}
