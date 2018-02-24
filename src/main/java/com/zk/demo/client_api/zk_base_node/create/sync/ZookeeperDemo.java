package com.zk.demo.client_api.zk_base_node.create.sync;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.ZooDefs.Ids;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * 创建节点(sync)
 * Created by garychen on 2018/2/22.
 */
public class ZookeeperDemo {
    private static Logger logger = LoggerFactory.getLogger(ZookeeperDemo.class);
    private static CountDownLatch latch = new CountDownLatch(1);
    public static void main(String[] args) {
        try {
            ZooKeeper zooKeeper = new ZooKeeper("192.168.131.134:2181", 3000,new MyWatcher(latch));
            latch.await();

//            String path1 = zooKeeper.create("/zk-test-e-",          //path
//                                            "".getBytes(),          //data
//                                            Ids.OPEN_ACL_UNSAFE,    //acl
//                                            CreateMode.PERSISTENT);  //createMode
//            logger.info("path 1: [{}]" , path1);

            String path2 = zooKeeper.create("/zk-test-e-child","".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            logger.info("path 2: [{}]" , path2);

            Thread.sleep(2000);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }
    }
}
