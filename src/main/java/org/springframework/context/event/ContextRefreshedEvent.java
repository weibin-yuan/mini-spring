package org.springframework.context.event;

import org.springframework.context.ApplicationContext;

/**
 * @author ywb
 * @Date 2022/6/28 17:57
 */
public class ContextRefreshedEvent extends ApplicationContextEvent {
    public ContextRefreshedEvent(ApplicationContext source) {
        super(source);
    }
}
