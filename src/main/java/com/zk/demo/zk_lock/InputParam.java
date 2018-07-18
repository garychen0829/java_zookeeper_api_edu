package com.zk.demo.zk_lock;

/**
 * @author: garychen
 * @Date: 2018/7/18 16:54
 * @Description:
 */
public class InputParam {
    private String str;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("InputParam{");
        sb.append("str='").append(str).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }
}
