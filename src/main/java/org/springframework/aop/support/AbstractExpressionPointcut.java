package org.springframework.aop.support;


import java.io.Serializable;

/**
 * @author ywb
 * @Date 2022/6/29 18:15
 */
public abstract class AbstractExpressionPointcut implements ExpressionPointcut, Serializable {
    private String location;

    private String expression;

    @Override
    public String getExpression() {
        return expression;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }
}
