package org.springframework.test.expanding;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.bean.Car;
import org.springframework.test.bean.Person;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author ywb
 * @Date 2022/7/14 17:48
 */
public class AnnotationTest {

    @Test
    public void testAnnotation() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:value-annotation.xml");

        Car car = applicationContext.getBean("car", Car.class);
        assertThat(car.getBrand()).isEqualTo("lamborghini");

        Person person = applicationContext.getBean(Person.class);
        assertThat(person.getCar()).isNotNull();
    }
}
