package org.springframework.context.event;

import org.springframework.context.ApplicationContext;

/**
 * @author ywb
 * @Date 2022/6/29 14:41
 */
public class ContextClosedEvent extends ApplicationContextEvent {
    public ContextClosedEvent(ApplicationContext source) {
        super(source);
    }
}
