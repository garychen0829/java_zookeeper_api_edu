package com.zk.demo.client_api.zk_base_node.create.async;

import org.apache.zookeeper.AsyncCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 异步回调函数实现类
 * Created by garychen on 2018/2/22.
 */
public class MyStringCallback implements AsyncCallback.StringCallback {
    private static Logger logger = LoggerFactory.getLogger(MyStringCallback.class);
    @Override
    public void processResult(int rc, String path, Object ctx, String name) {
        logger.info("Create path result:[{}] path:[{}] ctx:[{}] name:[{}]", rc,  path,  ctx,  name);
    }
}
