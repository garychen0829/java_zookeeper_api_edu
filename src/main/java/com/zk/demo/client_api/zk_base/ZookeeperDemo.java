package com.zk.demo.client_api.zk_base;

import org.apache.zookeeper.ZooKeeper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * 创建会话
 * Created by garychen on 2018/2/22.
 */
public class ZookeeperDemo {
    private static Logger logger = LoggerFactory.getLogger(ZookeeperDemo.class);
    private static CountDownLatch latch = new CountDownLatch(1);

    public static void main(String[] args) {
        try {
            ZooKeeper zooKeeper = new ZooKeeper("127.0.0.1:2181", 3000, new MyWatcher(latch));

            logger.info("====== zooKeeper: [{}]", zooKeeper);
            latch.await();

            Thread.sleep(2000);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
