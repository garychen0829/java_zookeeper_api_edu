package com.zk.demo.zk_lock.demo1;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: garychen
 * @Date: 2018/7/5 14:51
 * @Description:
 */
public class OrderCodeGenerator {

    private static int i = 0;

    public String getOrderCode() {
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss|");
        return sdf.format(now) + ++i;
    }
}
