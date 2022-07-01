package org.springframework.test.service;

/**
 * @author ywb
 * @Date 2022/7/1 11:46
 */
public class WorldServiceImpl implements WorldService {
    @Override
    public void explode() {
        System.out.println("The Earth is going to explode");
    }
}
