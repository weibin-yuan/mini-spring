package org.springframework.test.ioc;

import org.junit.Test;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.CglibSubclassingInstantiationStrategy;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.InstantiationStrategy;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author derekyi
 * @date 2020/11/24
 */
public class SimpleBeanContainerTest {

	@Test
	public void testBeanFactory() throws Exception {
		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
		InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();
//		beanFactory.setInstantiationStrategy(instantiationStrategy);
		PropertyValues pvs = new PropertyValues();
		pvs.addPropertyValue(new PropertyValue("age", 18));
		pvs.addPropertyValue(new PropertyValue("name", "ywb"));
		BeanDefinition beanDefinition = new BeanDefinition(Person.class, pvs);
		beanFactory.registerBeanDefinition("person", beanDefinition);

		Person person = (Person) beanFactory.getBean("person");
		System.out.println(person);
		assertThat(person.getName()).isEqualTo("ywb");
		assertThat(person.getAge()).isEqualTo(18);
	}

}
