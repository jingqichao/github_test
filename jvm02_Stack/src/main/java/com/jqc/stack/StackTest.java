package com.jqc.stack;

/**
 * 栈异常Exception in thread "main" java.lang.StackOverflowError
 * 默认情况下栈的数据：11207，count打印了11056次（不固定）
 * 设置栈的大小：-Xss256k，count打印了2466次（不固定）
 * 但是比默认的要少了很多次
 * 就直接抛出StackOverflowError异常了
 *
 */
public class StackTest {
    private static int count = 1;
    public static void main(String[] args) {
        System.out.println(count);
        count++;
        main(args);//Exception in thread "main" java.lang.StackOverflowError
    }
}
