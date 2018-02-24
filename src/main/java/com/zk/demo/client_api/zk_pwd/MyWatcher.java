package com.zk.demo.client_api.zk_pwd;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;

/**
 * Created by garychen on 2018/2/22.
 */
public class MyWatcher implements Watcher {
    private static Logger logger = LoggerFactory.getLogger(MyWatcher.class);
    private CountDownLatch latch;
    public MyWatcher(CountDownLatch latch) {
        this.latch=latch;
    }

    @Override
    public void process(WatchedEvent event) {
        logger.info("WatchedEvent event:[{}]", event);
        if (Event.KeeperState.SyncConnected == event.getState()){

            latch.countDown();
        }

    }
}
