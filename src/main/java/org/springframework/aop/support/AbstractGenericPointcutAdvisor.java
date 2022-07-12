package org.springframework.aop.support;

import org.aopalliance.aop.Advice;

/**
 * @author ywb
 * @Date 2022/7/7 18:23
 */
public abstract class AbstractGenericPointcutAdvisor extends AbstractPointcutAdvisor {

    private Advice advice;

    public AbstractGenericPointcutAdvisor() {
        this.advice = EMPTY_ADVICE;
    }

    public void setAdvice(Advice advice) {
        this.advice = advice;
    }

    @Override
    public Advice getAdvice() {
        return this.advice;
    }
}
