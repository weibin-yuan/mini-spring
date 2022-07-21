package org.springframework.test.service;

/**
 * @author ywb
 * @Date 2022/7/1 11:46
 */
public class WorldServiceImpl implements WorldService {
    private String name;

    @Override
    public void explode() {
        System.out.println("The " + name + " is going to explode");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
