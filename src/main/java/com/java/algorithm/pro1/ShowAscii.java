package com.java.algorithm.pro1;

/**
 * 类描述：打印 asc码表
 *
 * @author hui2.chen
 * @date 2018/9/5
 */
public class ShowAscii {
    public static void main(String[] args) {
        String temp = "";
        for (int i = 32; i <= 126; i++) {
            char c = (char) i;
            temp = i < 100 ? ("0" + i) : ("" + i);

            System.out.print(temp + " = " + c + "      ");
            if ((i-31)%8==0) {
                System.out.print("\n");
            }
        }
    }
}
