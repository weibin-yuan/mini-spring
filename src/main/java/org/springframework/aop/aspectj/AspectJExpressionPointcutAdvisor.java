package org.springframework.aop.aspectj;

import org.springframework.aop.Pointcut;
import org.springframework.aop.support.AbstractGenericPointcutAdvisor;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

/**
 * @author ywb
 * @Date 2022/7/7 18:24
 */
public class AspectJExpressionPointcutAdvisor extends AbstractGenericPointcutAdvisor implements BeanFactoryAware {
    private AspectJExpressionPointcut pointcut;

    public void setExpression(String expression) {
        this.pointcut = new AspectJExpressionPointcut(expression);
    }

    public String getExpression() {
        return this.pointcut.getExpression();
    }

    @Override
    public Pointcut getPointcut() {
        return this.pointcut;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.pointcut.setBeanFactory(beanFactory);
    }
}
