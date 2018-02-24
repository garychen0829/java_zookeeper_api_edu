package com.zk.demo.client_api.zk_pwd;

import org.apache.zookeeper.ZooKeeper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * 创建会话 by sessionId,passwd
 * Created by garychen on 2018/2/22.
 */
public class ZookeeperDemo {
    private static Logger logger = LoggerFactory.getLogger(ZookeeperDemo.class);
    private static CountDownLatch latch = new CountDownLatch(1);
    private static CountDownLatch latch1 = new CountDownLatch(1);
    public static void main(String[] args) {
        try {
            ZooKeeper zooKeeper1 = new ZooKeeper("192.168.131.134:2181", 3000,new MyWatcher(latch));
            logger.info("zooKeeper 1:[{}]" , zooKeeper1);
            latch.await();
            long sessionId = zooKeeper1.getSessionId();
            byte[] passwd = zooKeeper1.getSessionPasswd();
            logger.info("zooKeeper=> sessionId:[{}], passwd:[{}]" , sessionId, new String(passwd));


            ZooKeeper zooKeeper2 = new ZooKeeper("192.168.131.134:2181", 3000,new MyWatcher2(latch1),sessionId,passwd);
            logger.info("zooKeeper 2:[{}]" , zooKeeper2);
            Thread.sleep(2000);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
