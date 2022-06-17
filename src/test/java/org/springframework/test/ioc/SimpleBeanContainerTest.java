package org.springframework.test.ioc;

import org.junit.Test;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanReference;
import org.springframework.beans.factory.support.CglibSubclassingInstantiationStrategy;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.InstantiationStrategy;
import org.springframework.test.ioc.bean.Car;
import org.springframework.test.ioc.bean.Person;

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
		// car实例化
		PropertyValues pvsForCar = new PropertyValues();
		pvsForCar.addPropertyValue(new PropertyValue("brand", "Tesla"));
		BeanDefinition carBeanDefinition = new BeanDefinition(Car.class, pvsForCar);
		beanFactory.registerBeanDefinition("car", carBeanDefinition);
		// person实例化
		PropertyValues pvs = new PropertyValues();
		pvs.addPropertyValue(new PropertyValue("age", 18));
		pvs.addPropertyValue(new PropertyValue("name", "ywb"));
		// person依赖car
		pvs.addPropertyValue(new PropertyValue("car", new BeanReference("car")));
		BeanDefinition beanDefinition = new BeanDefinition(Person.class, pvs);
		beanFactory.registerBeanDefinition("person", beanDefinition);

		Person person = (Person) beanFactory.getBean("person");
		System.out.println(person);
		assertThat(person.getName()).isEqualTo("ywb");
		assertThat(person.getAge()).isEqualTo(18);
		Car car = person.getCar();
		assertThat(car).isNotNull();
		assertThat(car.getBrand()).isEqualTo("Tesla");
	}

}
