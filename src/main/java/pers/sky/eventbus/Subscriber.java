package pers.sky.eventbus;

import java.lang.reflect.Method;

/**
 * 监听者
 *
 * @author fei
 */
public class Subscriber<T> {

    private final EventHandler<T> handler;

    private final Class<T> eventClass;

    public Subscriber(EventHandler<T> handler) {
        this.handler = handler;
        eventClass = getClazz(handler);
    }


    public void handle(T event) {
        handler.handleEvent(event);
    }

    private Class<T> getClazz(EventHandler<T> handler) {
        for (Method method : handler.getClass().getDeclaredMethods()) {
            Class<?>[] parameterTypes = method.getParameterTypes();
            if (method.getName().equals("handleEvent") && parameterTypes.length == 1) {
                return (Class<T>) parameterTypes[0].getClass();
            }
        }
        return null;
    }

    public Class<T> getEventClass() {
        return eventClass;
    }
}
