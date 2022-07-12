package org.springframework.test.aop;

import org.junit.Test;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.aspectj.AspectJExpressionPointcutAdvisor;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.service.WorldService;

/**
 * @author ywb
 * @Date 2022/7/12 14:41
 */
public class AutoProxyTest {

    @Test
    public void testAutoProxy() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:auto-proxy.xml");
        AspectJExpressionPointcutAdvisor advisor = applicationContext.getBean("pointcutAdvisor", AspectJExpressionPointcutAdvisor.class);
        AspectJExpressionPointcut pointcut = applicationContext.getBean("pointcut", AspectJExpressionPointcut.class);
        advisor.setExpression(pointcut.getExpression());
        // 获取代理对象
        WorldService worldService = applicationContext.getBean("worldService", WorldService.class);
        worldService.explode();
    }
}
