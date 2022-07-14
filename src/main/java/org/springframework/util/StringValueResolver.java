package org.springframework.util;

/**
 * @author ywb
 * @Date 2022/7/14 13:51
 */
@FunctionalInterface
public interface StringValueResolver {
    String resolveStringValue(String strVal);
}
