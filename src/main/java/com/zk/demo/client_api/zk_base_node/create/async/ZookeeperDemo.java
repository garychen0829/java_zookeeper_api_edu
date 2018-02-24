package com.zk.demo.client_api.zk_base_node.create.async;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * 创建节点(async)
 * Created by garychen on 2018/2/22.
 */
public class ZookeeperDemo {
    private static Logger logger = LoggerFactory.getLogger(ZookeeperDemo.class);
    private static CountDownLatch latch = new CountDownLatch(1);
    public static void main(String[] args) {
        try {
            ZooKeeper zooKeeper = new ZooKeeper("192.168.131.134:2181", 3000,new MyWatcher(latch));
            latch.await();

            zooKeeper.create("/zk-test-e-",          //path
                             "".getBytes(),          //data
                             Ids.OPEN_ACL_UNSAFE,    //acl
                             CreateMode.EPHEMERAL,   //createMode
                             new MyStringCallback(), //callback
                             "I am Context");        //Context

            zooKeeper.create("/zk-test-e-child", "".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL, new MyStringCallback(), "I am Context");


            Thread.sleep(2000);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
