package pers.sky.eventbus;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 监听者注册中心
 *
 * @author fei
 */
public class SubscriberRegistry<T> {

    private ConcurrentMap<Class<? extends T>, CopyOnWriteArrayList<Subscriber<? extends T>>> subscriberMap;

    public SubscriberRegistry() {
        this.subscriberMap = new ConcurrentHashMap<>();
    }

    <E extends T> void register(EventHandler<E> handler) {
        Subscriber<E> subscriber = new Subscriber<>(handler);
        subscriberMap.computeIfAbsent(subscriber.getEventClass(), k -> new CopyOnWriteArrayList<>()).add(subscriber);
    }


    <E extends T> List<Subscriber<? extends T>> getSubscribers(E event) {
        return subscriberMap.get(event.getClass());
    }

}
