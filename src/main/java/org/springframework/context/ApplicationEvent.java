package org.springframework.context;

import java.util.EventObject;

/**
 * @author ywb
 * @Date 2022/6/28 16:45
 */
public class ApplicationEvent extends EventObject {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ApplicationEvent(Object source) {
        super(source);
    }
}
