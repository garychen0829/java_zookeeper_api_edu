package com.zk.demo.zk_lock.demo1;

import com.zk.demo.client_api.zk_base.MyWatcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;

/**
 * @author: garychen
 * @Date: 2018/7/5 15:48
 * @Description:
 */
public class ZkWatcherDemo {
    public static void main(String[] args) throws IOException {
        ZooKeeper zooKeeper = new ZooKeeper("192.168.131.134:2181", 3000, new WatcherDemo());
    }
}
