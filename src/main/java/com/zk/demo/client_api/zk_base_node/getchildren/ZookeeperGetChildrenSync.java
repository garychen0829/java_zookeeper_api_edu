package com.zk.demo.client_api.zk_base_node.getchildren;

import org.apache.zookeeper.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @author: garychen
 * @Date: 2018/7/6 11:12
 * @Description:
 */
public class ZookeeperGetChildrenSync implements Watcher {
    private static Logger logger = LoggerFactory.getLogger(ZookeeperGetChildrenSync.class);
    private static CountDownLatch latch = new CountDownLatch(1);
    static ZooKeeper zk = null;

    public static void main(String[] args) throws Exception {
        String path = "/zk-edu-test1";
        zk = new ZooKeeper("192.168.131.134:2181", 5000, new ZookeeperGetChildrenSync());
        latch.await();
        zk.create(path, "".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        zk.create(path + "/child-1", "".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);

        List<String> childrenList = zk.getChildren(path, true);
        System.out.println(childrenList);

        zk.create(path + "/child-2", "".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
        Thread.sleep(Integer.MAX_VALUE);
    }

    @Override
    public void process(WatchedEvent event) {
        logger.info("===== event: {}", event);
        if (Watcher.Event.KeeperState.SyncConnected == event.getState()) {
            if (Watcher.Event.EventType.None == event.getType() && null == event.getPath()) {
                latch.countDown();
            } else if (event.getType() == Watcher.Event.EventType.NodeChildrenChanged) {
                try {
                    System.out.println("子节点发生变化 ReGet Child :" + zk.getChildren(event.getPath(), true));
                } catch (KeeperException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
