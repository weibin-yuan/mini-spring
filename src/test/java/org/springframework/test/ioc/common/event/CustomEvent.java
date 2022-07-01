package org.springframework.test.ioc.common.event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ApplicationContextEvent;

/**
 * @author ywb
 * @Date 2022/6/29 14:46
 */
public class CustomEvent extends ApplicationContextEvent {

    public CustomEvent(ApplicationContext source) {
        super(source);
    }
}