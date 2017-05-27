package pers.sky.eventbus;

/**
 * 事件处理接口
 *
 * @author fei
 */
@FunctionalInterface
public interface EventHandler<T> {
    /**
     * 处理事件
     *
     * @param event
     */
    void handleEvent(T event);


}
