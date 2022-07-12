package org.springframework.aop;

/**
 * @author ywb
 * @Date 2022/7/7 18:18
 */
public interface PointcutAdvisor extends Advisor {
    Pointcut getPointcut();
}
