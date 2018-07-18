package com.zk.demo.zk_lock.demo1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: garychen
 * @Date: 2018/7/5 14:55
 * @Description:
 */
public class OrderServiceImpl implements OrderService {
    private static OrderCodeGenerator ocg = new OrderCodeGenerator();

    /**
     * 可重入锁
     */
    private static Lock lock = new ReentrantLock();

    @Override
    public void createOrder() {
        String orderCode = null;

        try {
            lock.lock();
            //获取订单
            orderCode = ocg.getOrderCode();

        }finally {
            lock.unlock();
        }

        //方法1
//        synchronized (ocg) {
//            orderCode = ocg.getOrderCode();
//        }

        System.out.println(Thread.currentThread().getName() + "===>" + orderCode);
    }
}
