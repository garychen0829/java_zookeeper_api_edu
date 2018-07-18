package com.zk.demo.zk_lock.demo1;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;

/**
 * @author: garychen
 * @Date: 2018/7/5 15:54
 * @Description:
 */
public class WatcherDemo implements Watcher {

    @Override
    public void process(WatchedEvent event) {
        System.out.println("event: " + event.getState());
    }
}
