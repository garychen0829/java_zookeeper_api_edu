package com.zk.demo.client_api.zk_base_node.delete;

import org.apache.zookeeper.AsyncCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;


/**
 * Created by garychen on 2018/2/23.
 */
public class MyVoidCallback implements AsyncCallback.VoidCallback {
    private static Logger logger = LoggerFactory.getLogger(MyVoidCallback.class);

    private CountDownLatch latch;
    public MyVoidCallback(CountDownLatch latch){
        this.latch = latch;
    }

    @Override
    public void processResult(int rc, String path, Object ctx) {
        logger.info("delete path result:[{}] path:[{}] ctx:[{}] ", rc,  path,  ctx);
        latch.countDown();
    }
}
