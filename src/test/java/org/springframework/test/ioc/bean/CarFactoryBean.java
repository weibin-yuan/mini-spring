package org.springframework.test.ioc.bean;

import org.springframework.beans.factory.FactoryBean;

/**
 * @Date 2022/6/27 17:52
 * @Created ywb
 */
public class CarFactoryBean implements FactoryBean<Car> {
    private String brand;

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public Car getObject() throws Exception {
        Car car = new Car();
        car.setBrand(brand);
        return car;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
