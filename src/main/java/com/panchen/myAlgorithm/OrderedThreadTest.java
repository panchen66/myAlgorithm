package com.panchen.myAlgorithm;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 通过n个线程顺序循环打印从0至100
 * 
 * @author pc
 *
 */
public class OrderedThreadTest extends Thread {

    private AtomicLong count = new AtomicLong(1);
    private int nowOrder = 1;

    public class OrderedThread extends Thread {

        int order;

        public OrderedThread(int order) {
            this.order = order;
        }

        @Override
        public void run() {
            while (100 >= count.get()) {
                if (nowOrder == order) {
                    System.out.println(order + ":" + count.getAndIncrement());
                    if (3 == nowOrder) {

                        nowOrder = 1;
                        continue;
                    }
                    nowOrder++;
                }
            }
        }

    }

    public static void main(String[] args) {
        OrderedThreadTest test = new OrderedThreadTest();
        OrderedThread thread1 = test.new OrderedThread(1);
        OrderedThread thread2 = test.new OrderedThread(2);
        OrderedThread thread3 = test.new OrderedThread(3);
        thread1.start();
        thread2.start();
        thread3.start();
        while (Boolean.TRUE) {
        }
    }
}
