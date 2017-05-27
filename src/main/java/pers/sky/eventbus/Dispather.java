package pers.sky.eventbus;

import java.util.Iterator;

/**
 * 事件分发器
 *
 * @author fei
 */
public abstract class Dispather {

    abstract void dispatch(Object event, Iterator<Subscriber> subscribers);
}
