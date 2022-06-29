package org.springframework.context;

/**
 * @author ywb
 * @Date 2022/6/29 14:55
 */
public interface ApplicationEventPublisher {
    void publishEvent(ApplicationEvent event);
}
