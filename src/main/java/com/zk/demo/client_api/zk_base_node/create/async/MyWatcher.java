package com.zk.demo.client_api.zk_base_node.create.async;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;

import java.util.concurrent.CountDownLatch;

/**
 * Created by garychen on 2018/2/22.
 */
public class MyWatcher implements Watcher {
    private CountDownLatch latch;
    public MyWatcher(CountDownLatch latch) {
        this.latch=latch;
    }

    @Override
    public void process(WatchedEvent event) {
        if (Event.KeeperState.SyncConnected == event.getState()){
            System.out.println(event);
            latch.countDown();
        }

    }
}
