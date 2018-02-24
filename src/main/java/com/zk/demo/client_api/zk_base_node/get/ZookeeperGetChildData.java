package com.zk.demo.client_api.zk_base_node.get;

import com.zk.demo.client_api.zk_base_node.create.sync.MyWatcher;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * Created by garychen on 2018/2/23.
 */
public class ZookeeperGetChildData {
    private static CountDownLatch latch = new CountDownLatch(1);
    private static CountDownLatch latch1 = new CountDownLatch(1);
    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        ZooKeeper zooKeeper = new ZooKeeper("192.168.131.134:2181", 3000,new MyWatcher(latch));
        latch.await();

        //zooKeeper.getChildren()
        latch1.await();
    }
}
