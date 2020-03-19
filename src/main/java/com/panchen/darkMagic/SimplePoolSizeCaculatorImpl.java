package com.panchen.darkMagic;

import java.lang.management.ManagementFactory;
import java.math.BigDecimal;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Description:
 * @author: chenp
 * @date: 2020/03/13 10:30
 */
public class SimplePoolSizeCaculatorImpl extends PoolSizeCalculator {


    @Override
    protected Runnable createTask() {
        return new Task();
    }

    @Override
    protected BlockingQueue<Runnable> createWorkQueue(int capacity) {
        return new LinkedBlockingQueue<>(capacity);
    }

    @Override
    protected long getCurrentThreadCPUTime() {
        //the total CPU time for the current thread in nanoseconds
        return ManagementFactory.getThreadMXBean().getCurrentThreadCpuTime();
    }


    public static void main(String[] args) {
        PoolSizeCalculator poolSizeCalculator = new SimplePoolSizeCaculatorImpl();
        poolSizeCalculator.calculateBoundaries(new BigDecimal(1.0), new BigDecimal(100000));
    }


    private class Task implements Runnable {

        @Override
        public void run() {

        }
    }
}

