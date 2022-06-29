package org.springframework.context;

import java.util.EventListener;

/**
 * @author ywb
 * @Date 2022/6/28 16:42
 */
@FunctionalInterface
public interface ApplicationListener<E extends ApplicationEvent> extends EventListener {
    void onApplicationEvent(E event);
}
