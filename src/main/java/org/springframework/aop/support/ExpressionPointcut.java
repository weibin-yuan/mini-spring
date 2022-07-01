package org.springframework.aop.support;

import org.springframework.aop.Pointcut;

/**
 * @author ywb
 * @Date 2022/6/29 18:13
 */
public interface ExpressionPointcut extends Pointcut {
    String getExpression();
}
