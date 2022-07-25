package org.springframework.test.expanding;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.bean.Car;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author ywb
 * @Date 2022/7/22 11:02
 */
public class TypeConversionTest {
    @Test
    public void testConversionService() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:type-conversion.xml");

        Car car = applicationContext.getBean("car", Car.class);
        assertThat(car.getPrice()).isEqualTo(1000000);
        assertThat(car.getProduceDate()).isEqualTo(LocalDate.of(2021, 1, 1));
    }
}
