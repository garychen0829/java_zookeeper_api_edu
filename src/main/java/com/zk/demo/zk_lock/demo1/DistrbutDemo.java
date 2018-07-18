package com.zk.demo.zk_lock.demo1;

import java.util.concurrent.CountDownLatch;

/**
 * @author: garychen
 * @Date: 2018/7/5 14:57
 * @Description:
 */
public class DistrbutDemo {
    public static void main(String[] args) {
        int currs = 20;

        CountDownLatch latch = new CountDownLatch(currs);

        for (int i = 0; i < currs; i++) {
            new Thread(()->{
                OrderService os = new OrderServiceImpl();

                latch.countDown();

                try {
                    latch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //创建订单号
                os.createOrder();
            }).start();
        }
    }
}
