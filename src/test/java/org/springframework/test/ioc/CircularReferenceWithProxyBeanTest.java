package org.springframework.test.ioc;

import org.junit.Test;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.aspectj.AspectJExpressionPointcutAdvisor;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.bean.A;
import org.springframework.test.bean.B;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * @author ywb
 * @Date 2022/7/29 16:34
 */
public class CircularReferenceWithProxyBeanTest {

	@Test
	public void testCircularReference() throws Exception {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:circular-reference-with-proxy-bean.xml");
		// 需要注释容器中提前实例化单例bean的代码
		AspectJExpressionPointcutAdvisor advisor = applicationContext.getBean("pointcutAdvisor", AspectJExpressionPointcutAdvisor.class);
		AspectJExpressionPointcut pointcut = applicationContext.getBean("pointcut", AspectJExpressionPointcut.class);
		advisor.setExpression(pointcut.getExpression());
		A a = applicationContext.getBean("a", A.class);
		B b = applicationContext.getBean("b", B.class);

		//增加二级缓存不能解决有代理对象时的循环依赖。
		//a被代理，放进二级缓存earlySingletonObjects中的是实例化后的A，而放进一级缓存singletonObjects中的是被代理后的A，实例化b时从earlySingletonObjects获取a，所以b.getA() != a
		assertThat(b.getA() == a).isTrue();
	}
}
