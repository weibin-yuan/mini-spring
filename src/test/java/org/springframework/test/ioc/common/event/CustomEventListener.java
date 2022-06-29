package org.springframework.test.ioc.common.event;

import org.springframework.context.ApplicationListener;

/**
 * @author ywb
 * @Date 2022/6/29 14:36
 */
public class CustomEventListener implements ApplicationListener<CustomEvent> {
    @Override
    public void onApplicationEvent(CustomEvent event) {
        System.out.println(this.getClass().getName());
    }
}
